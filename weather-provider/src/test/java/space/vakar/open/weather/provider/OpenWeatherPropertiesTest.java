package space.vakar.open.weather.provider;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OpenWeatherPropertiesTest {

  private final OpenWeatherProperties openWeatherProperties = OpenWeatherProperties.getInstance();

  private static final String URL = "http://api.openweathermap.org";
  private static final String END_POINT = "/data/2.5/weather";
  private static final String KEY = "valid_app_id";

  private static final String FILE_DOES_NOT_EXIST = "noFilePath";

  @Test
  @DisplayName("url should be valid")
  public void openWeatherPropertiesUrlTest() {
    assertEquals(URL, openWeatherProperties.getUrl());
  }

  @Test
  @DisplayName("api end point should be valid")
  public void openWeatherPropertiesEndPointTest() {
    assertEquals(END_POINT, openWeatherProperties.getEndPoint());
  }

  @Test
  @DisplayName("application key should be valid")
  public void openWeatherPropertiesKeyTest() {
    assertEquals(KEY, openWeatherProperties.getKey());
  }

  @Test
  @DisplayName("when property file does not exist")
  public void openWeatherPropertiesNoFileTest() {
    assertThrows(
        OpenWeatherProviderException.class,
        () -> OpenWeatherProperties.getInstanceWithProperties(FILE_DOES_NOT_EXIST),
        "should throw OpenWeatherProviderException");
  }
}
