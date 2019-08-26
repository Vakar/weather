package space.vakar.open.weather.provider;

import java.io.InputStream;
import java.util.Properties;

class ApiClientBuilder {

  static final String PROPERTIES_FILE = "/openweather.properties";

  static final String URL_PROPERTY_NAME = "open.weather.server.url";
  static final String END_POINT_PROPERTY_NAME = "current.weather.end.point";
  static final String APP_ID_PROPERTY_NAME = "app.id";

  private static final String PROPERTY_ERROR_MESSAGE = "Can't read OpenWeather properties file.";

  private ApiClientBuilder() {
    throw new IllegalStateException("Utility class");
  }

  static ApiClientImpl getCustomJsonApiConnector(String serverName, String endPoint, String appId) {
    return new ApiClientImpl(serverName, endPoint, appId);
  }

  static ApiClientImpl getDejaultJsonApiConnector() {
    Properties properties = readPropertiesFromFile(PROPERTIES_FILE);
    return createJsonApiConnectorFromProperties(properties);
  }

  static ApiClientImpl createJsonApiConnectorFromProperties(Properties properties) {
    String url = properties.getProperty(URL_PROPERTY_NAME);
    String endPoint = properties.getProperty(END_POINT_PROPERTY_NAME);
    String appId = properties.getProperty(APP_ID_PROPERTY_NAME);
    return new ApiClientImpl(url, endPoint, appId);
  }

  // TODO: move to separate util class | use abstraction for this class & other util properties
  // class
  static Properties readPropertiesFromFile(String fileName) {
    Properties properties = new Properties();
    try (InputStream propertiesFileInputStream =
        ApiClientBuilder.class.getResourceAsStream(fileName)) {
      properties.load(propertiesFileInputStream);
    } catch (Exception e) {
      throw new OpenWeatherException(PROPERTY_ERROR_MESSAGE, e);
    }
    return properties;
  }
}
