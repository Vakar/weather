package space.vakar.open.weather.persistence;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.h2.tools.RunScript;
import space.vakar.weather.domain.model.City;

public class DaoCityTest extends DatabaseTestConfig {

  private Dao<City> cityDao = new DaoCity();

  private DataFileLoader loader = new FlatXmlDataFileLoader();

  private static final String TABLE_NAME = "CITIES";
  private static final String COLUMN_NAME = "NAME";

  private static final String CITIES_DATASET_FOLDER = "/datasets/cities";
  private static final String CITIES_START_DATASET = CITIES_DATASET_FOLDER + "/start.xml";
  private static final String CITIES_CREATE_DATASET = CITIES_DATASET_FOLDER + "/create.xml";
  private static final String CITIES_UPDATE_DATASET = CITIES_DATASET_FOLDER + "/update.xml";
  private static final String CITIES_DELETE_DATASET = CITIES_DATASET_FOLDER + "/delete.xml";
  private static final String SCHEMA_FILE = "classpath:schema.sql";

  private City berlin = new City(2950159, "Berlin", "DE");
  private City monaco = new City(2993458, "Monaco", "FR");

  public DaoCityTest(String name) {
    super(name);
  }

  @Override
  protected void setUp() throws Exception {
    JdbcConnectionProperties connProp = JdbcConnectionProperties.getInstance();
    String url = connProp.getUrl();
    String user = connProp.getUser();
    String psw = connProp.getPsw();
    RunScript.execute(url, user, psw, SCHEMA_FILE, StandardCharsets.UTF_8, false);
    super.setUp();
  }

  @Override
  protected IDataSet getDataSet() {
    return loader.load(CITIES_START_DATASET);
  }

  public void testCreate() throws Exception {
    cityDao.create(berlin);
    Assertion.assertEquals(getExpectedTable(CITIES_CREATE_DATASET), getActualTable());
  }

  public void testRead() throws SQLException {
    City actualCity = cityDao.read(monaco.getId());
    assertEquals(monaco, actualCity);
  }

  public void testUpdate() throws Exception {
    monaco.setCountry("US");
    cityDao.update(monaco);
    Assertion.assertEquals(getExpectedTable(CITIES_UPDATE_DATASET), getActualTable());
  }

  public void testDelete() throws Exception {
    cityDao.delete(monaco.getId());
    Assertion.assertEquals(getExpectedTable(CITIES_DELETE_DATASET), getActualTable());
  }

  public void testSearchCitiesBySubstring_WhenExist() throws SQLException {
    String substring = "ona";
    List<City> actualCities = cityDao.search(COLUMN_NAME, substring);
    List<City> expectedCities = Collections.singletonList(monaco);
    assertEquals(expectedCities, actualCities);
  }

  public void testSearchCitiesBySubstring_WhenDoesNotExist() throws SQLException {
    String substring = "ina";
    List<City> actualCities = cityDao.search(COLUMN_NAME, substring);
    List<City> expectedCities = Collections.emptyList();
    assertEquals(expectedCities, actualCities);
  }

  private ITable getActualTable() throws Exception {
    IDataSet databaseDataSet = getConnection().createDataSet();
    return databaseDataSet.getTable(TABLE_NAME);
  }

  private ITable getExpectedTable(String datasetPath) throws DataSetException {
    IDataSet expectedDataSet = loader.load(datasetPath);
    return expectedDataSet.getTable(TABLE_NAME);
  }
}
