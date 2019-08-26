package org.open.weather.persistence;

import java.sql.Connection;
import java.sql.SQLException;

interface ConnectionPool {

  Connection getConnection() throws SQLException;

}
