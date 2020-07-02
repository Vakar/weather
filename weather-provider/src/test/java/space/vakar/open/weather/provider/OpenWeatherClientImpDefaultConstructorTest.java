package space.vakar.open.weather.provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OpenWeatherClientImpDefaultConstructorTest {

  private final OpenWeatherClientImp client = new OpenWeatherClientImp();

  private static final String URL = "http://api.openweathermap.org";
  private static final String END_POINT = "/data/2.5/weather";
  private static final String KEY = "valid_app_id";

  @Test
  @DisplayName("url should be valid")
  public void openWeatherPropertiesUrlTest() {
    assertEquals(URL, client.getServiceUrl());
  }

  @Test
  @DisplayName("api end point should be valid")
  public void openWeatherPropertiesEndPointTest() {
    assertEquals(END_POINT, client.getWeatherEndPoint());
  }

  @Test
  @DisplayName("application key should be valid")
  public void openWeatherPropertiesKeyTest() {
    assertEquals(KEY, client.getAppId());
  }
}
