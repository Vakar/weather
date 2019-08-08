package space.vakar.open.weather.provider;

import static org.junit.Assert.assertEquals;
import org.apache.http.localserver.LocalTestServer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import space.vakar.open.weather.provider.ApiClient;
import space.vakar.open.weather.provider.ApiClientBuilder;
import space.vakar.open.weather.provider.OpenWeatherException;

public class ApiClientImplTest {

  private ApiClient apiClient = ApiClientBuilder.getDejaultJsonApiConnector();

  private static LocalTestServer server;

  private static final int VALID_CITY_ID = 1;
  private static final int INVALID_CITY_ID = 0;
  private static final String APP_ID = "valid_app_id";
  private static final String INVALID_APP_ID = "invalid_app_id";
  private static final String JSON = "{ \"weather\" : \"sunny\"}";

  private static final String WEATHER_END_POINT = "/data/2.5/weather";


  @Before
  public void setUp() {
    apiClient = ApiClientBuilder.getCustomJsonApiConnector(
        "http:/" + server.getServiceAddress(), WEATHER_END_POINT, APP_ID);
  }

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    server = new LocalTestServer(null, null);
    server.start();
    server.register("/data/2.5/*", new WeatherRequestHandler());
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    server.stop();
  }

  @Test
  public void shouldReturnJson_WhenAllRequesDataCorrect() {
    String responce = apiClient.getCityWeatherJsonByCityId(VALID_CITY_ID);
    assertEquals(JSON, responce);
  }

  @Test(expected = OpenWeatherException.class)
  public void shouldReturnOpenWeatherException_WhenCityIdInvalid() {
    apiClient.getCityWeatherJsonByCityId(INVALID_CITY_ID);
  }

  @Test(expected = OpenWeatherException.class)
  public void shouldReturnOpenWeatherException_WhenAppIdNotValid() {
    apiClient = ApiClientBuilder.getCustomJsonApiConnector(
        "http:/" + server.getServiceAddress(), WEATHER_END_POINT, INVALID_APP_ID);
    apiClient.getCityWeatherJsonByCityId(VALID_CITY_ID);
  }

}
