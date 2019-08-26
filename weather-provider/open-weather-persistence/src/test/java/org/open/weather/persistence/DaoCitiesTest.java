package org.open.weather.persistence;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.dbunit.Assertion;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.util.fileloader.DataFileLoader;
import org.dbunit.util.fileloader.FlatXmlDataFileLoader;
import org.h2.tools.RunScript;

public class DaoCitiesTest extends DatabaseTestConfig {

  private Dao<EntityCity> cityDao = new DaoCity();

  private DataFileLoader loader = new FlatXmlDataFileLoader();

  private static final String TABLE_NAME = "CITIES";
  private static final String COLUMN_NAME = "NAME";

  private static final String CITIES_DATASET_FOLDER = "/datasets/cities";
  private static final String CITIES_START_DATASET = CITIES_DATASET_FOLDER + "/start.xml";
  private static final String CITIES_CREATE_DATASET = CITIES_DATASET_FOLDER + "/create.xml";
  private static final String CITIES_UPDATE_DATASET = CITIES_DATASET_FOLDER + "/update.xml";
  private static final String CITIES_DELETE_DATASET = CITIES_DATASET_FOLDER + "/delete.xml";
  private static final String SCHEMA_FILE = "classpath:schema.sql";

  private EntityCity berlin = new EntityCity(2950159, "Berlin", "DE");
  private EntityCity monaco = new EntityCity(2993458, "Monaco", "FR");

  public DaoCitiesTest(String name) {
    super(name);
  }

  @Override
  protected void setUp() throws Exception {
    ConnectionProperties connProp = ConnectionProperties.getInstance();
    String url = connProp.getUrl();
    String user = connProp.getUser();
    String pswd = connProp.getPswd();
    RunScript.execute(url, user, pswd, SCHEMA_FILE, StandardCharsets.UTF_8, false);
    super.setUp();
  }

  @Override
  protected IDataSet getDataSet() throws Exception {
    return loader.load(CITIES_START_DATASET);
  }

  public void testCreate() throws SQLException, Exception {
    cityDao.create(berlin);
    Assertion.assertEquals(getExpectedTable(CITIES_CREATE_DATASET), getActualTable());
  }

  public void testRead() throws SQLException {
    EntityCity actualCity = cityDao.read(monaco.getId());
    assertEquals(monaco, actualCity);
  }

  public void testUpdate() throws SQLException, Exception {
    monaco.setCountry("US");
    cityDao.update(monaco);
    Assertion.assertEquals(getExpectedTable(CITIES_UPDATE_DATASET), getActualTable());
  }

  public void testDelete() throws SQLException, Exception {
    cityDao.delete(monaco.getId());
    Assertion.assertEquals(getExpectedTable(CITIES_DELETE_DATASET), getActualTable());
  }

  public void testSearchCitiesBySubstring_WhenExist() throws SQLException {
    String substring = "ona";
    List<EntityCity> actualCities = cityDao.search(COLUMN_NAME, substring);
    List<EntityCity> expectedCities = Arrays.asList(monaco);
    assertEquals(expectedCities, actualCities);
  }

  public void testSearchCitiesBySubstring_WhenDoesNotExist() throws SQLException {
    String substring = "ina";
    List<EntityCity> actualCities = cityDao.search(COLUMN_NAME, substring);
    List<EntityCity> expectedCities = Collections.emptyList();
    assertEquals(expectedCities, actualCities);
  }

  private ITable getActualTable() throws SQLException, Exception {
    IDataSet databaseDataSet = getConnection().createDataSet();
    return databaseDataSet.getTable(TABLE_NAME);
  }

  private ITable getExpectedTable(String datasetPath) throws DataSetException {
    IDataSet expectedDataSet = loader.load(datasetPath);
    return expectedDataSet.getTable(TABLE_NAME);
  }

}
