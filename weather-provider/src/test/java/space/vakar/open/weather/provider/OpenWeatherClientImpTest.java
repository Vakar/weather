package space.vakar.open.weather.provider;

import org.apache.http.localserver.LocalTestServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OpenWeatherClientImpTest {

  private OpenWeatherClient apiClient;

  private static LocalTestServer server;

  private static final int VALID_CITY_ID = 1;
  private static final int INVALID_CITY_ID = 0;
  private static final String APP_ID = "valid_app_id";
  private static final String INVALID_APP_ID = "invalid_app_id";
  private static final String JSON = "{ \"weather\" : \"sunny\"}";

  private static final String PROTOCOL = "http:/";
  private static final String WEATHER_END_POINT = "/data/2.5/weather";

  @BeforeAll
  public static void setUpBeforeClass() throws Exception {
    server = new LocalTestServer(null, null);
    server.start();
    server.register("/data/2.5/*", new OpenWeatherServerRequestHandler());
  }

  @BeforeEach
  public void setUp() {
    apiClient =
        new OpenWeatherClientImp(PROTOCOL + server.getServiceAddress(), WEATHER_END_POINT, APP_ID);
  }

  @AfterAll
  public static void tearDownAfterClass() throws Exception {
    server.stop();
  }

  @Test
  @DisplayName("when all request data correct")
  public void correctRequest() {
    String response = apiClient.getCityWeatherJsonByCityId(VALID_CITY_ID);
    assertEquals(JSON, response, "should return weather json");
  }

  @Test
  @DisplayName("when invalid city id")
  public void invalidCityId() {
    assertThrows(
        OpenWeatherProviderException.class,
        () -> apiClient.getCityWeatherJsonByCityId(INVALID_CITY_ID),
        "should throw OpenWeatherProviderException");
  }

  @Test
  @DisplayName("when invalid application id")
  public void invalidApplicationId() {
    apiClient =
        new OpenWeatherClientImp(
            PROTOCOL + server.getServiceAddress(), WEATHER_END_POINT, INVALID_APP_ID);
    assertThrows(
        OpenWeatherProviderException.class,
        () -> apiClient.getCityWeatherJsonByCityId(VALID_CITY_ID),
        "should throw OpenWeatherProviderException");
  }
}
