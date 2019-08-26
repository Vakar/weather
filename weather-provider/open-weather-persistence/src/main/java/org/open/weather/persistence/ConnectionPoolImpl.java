package org.open.weather.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.h2.jdbcx.JdbcConnectionPool;

class ConnectionPoolImpl implements ConnectionPool {

  private static ConnectionPool instance;

  private JdbcConnectionPool cp;

  private ConnectionPoolImpl() {
    Properties properties =
        PropertiesUtil.readPropertiesFromFile(PropertiesUtil.CONNECTION_PROPERTIES_FILE);
    String dbUrl = properties.getProperty(PropertiesUtil.CONNECTION_URL_PROPERTY_NAME);
    String user = properties.getProperty(PropertiesUtil.CONNECTION_USER_PROPERTY_NAME);
    String pass = properties.getProperty(PropertiesUtil.CONNECTION_PASS_PROPERTY_NAME);
    cp = JdbcConnectionPool.create(dbUrl, user, pass);
  }

  static ConnectionPool getConnectionPool() {
    if (instance == null) {
      instance = new ConnectionPoolImpl();
    }
    return instance;
  }

  @Override
  public Connection getConnection() throws SQLException {
    return cp.getConnection();
  }

}
