package space.vakar.open.weather.provider;

import static org.junit.Assert.assertEquals;

import java.util.Properties;
import org.junit.Before;
import org.junit.Test;
import space.vakar.open.weather.provider.ApiClientBuilder;
import space.vakar.open.weather.provider.ApiClientImpl;
import space.vakar.open.weather.provider.OpenWeatherException;

public class ApiClientBuilderTest {

  private static final String URL = "http://api.openweathermap.org";
  private static final String END_POINT = "/data/2.5/weather";
  private static final String APP_ID = "valid_app_id";

  static final String INVALID_PROPERTIES_FILE = "/openweather.proper";

  private Properties properties;

  @Before
  public void setUp() {
    properties = new Properties();
    properties.setProperty(ApiClientBuilder.URL_PROPERTY_NAME, URL);
    properties.setProperty(ApiClientBuilder.END_POINT_PROPERTY_NAME, END_POINT);
    properties.setProperty(ApiClientBuilder.APP_ID_PROPERTY_NAME, APP_ID);
  }

  @Test
  public void readPropertiesFromFileTest() {
    Properties actualProperties =
        ApiClientBuilder.readPropertiesFromFile(ApiClientBuilder.PROPERTIES_FILE);
    assertEquals(properties, actualProperties);
  }

  @Test(expected = OpenWeatherException.class)
  public void shouldThrowIoException_WhenCanNotReadPropertiesFile() {
    ApiClientBuilder.readPropertiesFromFile(INVALID_PROPERTIES_FILE);
  }

  @Test
  public void createJsonApiConnectorFromPropertiesTest() {
    ApiClientImpl actualConnector = new ApiClientImpl(URL, END_POINT, APP_ID);
    ApiClientImpl expectedConnector =
        ApiClientBuilder.createJsonApiConnectorFromProperties(properties);
    assertEquals(expectedConnector, actualConnector);
  }

}
