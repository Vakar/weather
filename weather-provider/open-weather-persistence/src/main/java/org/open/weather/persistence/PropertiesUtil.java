package org.open.weather.persistence;

import java.io.InputStream;
import java.util.Properties;

class PropertiesUtil {

  static final String CONNECTION_PROPERTIES_FILE = "/connection.properties";
  static final String CONNECTION_DRIVER_PROPERTY_NAME = "driver";
  static final String CONNECTION_URL_PROPERTY_NAME = "url";
  static final String CONNECTION_USER_PROPERTY_NAME = "user";
  static final String CONNECTION_PASS_PROPERTY_NAME = "pass";

  private PropertiesUtil() {}

  static Properties readPropertiesFromFile(String fileName) {
    Properties properties = new Properties();
    try (InputStream propertiesFileInputStream = 
        PropertiesUtil.class.getResourceAsStream(fileName)) {
      properties.load(propertiesFileInputStream);
    } catch (Exception e) {
      throw new OpenWeatherPersistenceException(e.getMessage(), e);
    }
    return properties;
  }

}
