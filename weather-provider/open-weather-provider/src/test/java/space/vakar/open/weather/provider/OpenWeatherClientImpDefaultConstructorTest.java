package space.vakar.open.weather.provider;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class OpenWeatherClientImpDefaultConstructorTest {
  
  private OpenWeatherClientImp client = new OpenWeatherClientImp();
  
  private static final String URL = "http://api.openweathermap.org";
  private static final String END_POINT = "/data/2.5/weather";
  private static final String KEY = "valid_app_id";
  
  @Test
  public void openWeatherPropertiesUrlTest() {
    assertEquals(URL, client.getServiceUrl());
  }
  
  @Test
  public void openWeatherPropertiesEndPointTest() {
    assertEquals(END_POINT, client.getWeatherEndPoint());
  }
  
  @Test
  public void openWeatherPropertiesKeyTest() {
    assertEquals(KEY, client.getAppId());
  }

}
