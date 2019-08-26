package org.open.weather.persistence;

import java.io.InputStream;
import java.util.Properties;

class ConnectionProperties {

  private static ConnectionProperties instance;

  private static final String PROPERTIES_FILE = "/connection.properties";
  private static final String DRIVER_PROPERTY_NAME = "driver";
  private static final String URL_PROPERTY_NAME = "url";
  private static final String USER_PROPERTY_NAME = "user";
  private static final String PSWD_PROPERTY_NAME = "pass";

  private String driver;
  private String url;
  private String user;
  private String pswd;

  private ConnectionProperties() {
    Properties properties = readPropertiesFromFile(PROPERTIES_FILE);
    this.driver = properties.getProperty(ConnectionProperties.DRIVER_PROPERTY_NAME);
    this.url = properties.getProperty(ConnectionProperties.URL_PROPERTY_NAME);
    this.user = properties.getProperty(ConnectionProperties.USER_PROPERTY_NAME);
    this.pswd = properties.getProperty(ConnectionProperties.PSWD_PROPERTY_NAME);
  }

  private static Properties readPropertiesFromFile(String fileName) {
    Properties properties = new Properties();
    try (InputStream propertiesFileInputStream =
        ConnectionProperties.class.getResourceAsStream(fileName)) {
      properties.load(propertiesFileInputStream);
    } catch (Exception e) {
      throw new OpenWeatherPersistenceException(e.getMessage(), e);
    }
    return properties;
  }

  static ConnectionProperties getInstance() {
    if (instance == null) {
      instance = new ConnectionProperties();
    }
    return instance;
  }

  public String getDriver() {
    return driver;
  }

  public void setDriver(String driver) {
    this.driver = driver;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getPswd() {
    return pswd;
  }

  public void setPswd(String pswd) {
    this.pswd = pswd;
  }

}
