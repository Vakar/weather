package space.vakar.open.weather.provider;

import java.util.Properties;
import space.vakar.weather.domain.util.PropertiesUtil;

public class OpenWeatherProperties extends PropertiesUtil {

  private static OpenWeatherProperties instance;  

  private static final String URL_PROPERTY_NAME = "open.weather.server.url";
  private static final String END_POINT_PROPERTY_NAME = "current.weather.end.point";
  private static final String APP_ID_PROPERTY_NAME = "app.id";

  private static final String DEFAULT_PROPERTIES_FILE = "/openweather.properties";
  
  private String url;
  private String endPoint;
  private String key;

  private OpenWeatherProperties() {
    this(DEFAULT_PROPERTIES_FILE);
  }
  
  private OpenWeatherProperties(String propertiesFile) {
    Properties properties;
    try {
      properties = readPropertiesFromFile(propertiesFile);
    } catch (Exception exp) {
      throw new OpenWeatherProviderException(exp.getMessage(), exp);
    }
    this.url = properties.getProperty(URL_PROPERTY_NAME);
    this.endPoint = properties.getProperty(END_POINT_PROPERTY_NAME);
    this.key = properties.getProperty(APP_ID_PROPERTY_NAME);
  }

  static OpenWeatherProperties getInstance() {
    if (instance == null) {
      instance = new OpenWeatherProperties();
    }
    return instance;
  }
  
  static OpenWeatherProperties getInstanceWithProperties(String propertiesFile) {
    return new OpenWeatherProperties(propertiesFile);
  }

  String getUrl() {
    return url;
  }

  void setUrl(String url) {
    this.url = url;
  }

  String getEndPoint() {
    return endPoint;
  }

  void setEndPoint(String endPoint) {
    this.endPoint = endPoint;
  }

  String getKey() {
    return key;
  }

  void setKey(String key) {
    this.key = key;
  }


}
