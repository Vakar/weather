package org.open.weather.persistence;

import java.sql.Connection;
import java.sql.SQLException;
import org.h2.jdbcx.JdbcConnectionPool;

class ConnectionPoolImpl implements ConnectionPool {

  private static ConnectionPool instance;

  private JdbcConnectionPool connectionPool;

  private ConnectionPoolImpl() {
    ConnectionProperties connProp = ConnectionProperties.getInstance();
    String url = connProp.getUrl();
    String user = connProp.getUser();
    String pswd = connProp.getPswd();
    connectionPool = JdbcConnectionPool.create(url, user, pswd);
  }

  static ConnectionPool getConnectionPool() {
    if (instance == null) {
      instance = new ConnectionPoolImpl();
    }
    return instance;
  }

  @Override
  public Connection getConnection() throws SQLException {
    return connectionPool.getConnection();
  }

}
