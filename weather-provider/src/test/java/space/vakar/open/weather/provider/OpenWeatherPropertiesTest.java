package space.vakar.open.weather.provider;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OpenWeatherPropertiesTest {
  
  private OpenWeatherProperties openWeatherProperties = OpenWeatherProperties.getInstance();
  
  private static final String URL = "http://api.openweathermap.org";
  private static final String END_POINT = "/data/2.5/weather";
  private static final String KEY = "valid_app_id";
  
  private static final String UNEXISTING_PROPERTIES_FILE = "unexistingFile";
  
  @Test
  public void openWeatherPropertiesUrlTest() {
    assertEquals(URL, openWeatherProperties.getUrl());
  }
  
  @Test
  public void openWeatherPropertiesEndPointTest() {
    assertEquals(END_POINT, openWeatherProperties.getEndPoint());
  }
  
  @Test
  public void openWeatherPropertiesKeyTest() {
    assertEquals(KEY, openWeatherProperties.getKey());
  }
  
  @Test(expected = OpenWeatherProviderException.class)
  public void openWeatherPropertiesAndUnexistingPropertyFile() {
    OpenWeatherProperties.getInstanceWithProperties(UNEXISTING_PROPERTIES_FILE);
  }

}
