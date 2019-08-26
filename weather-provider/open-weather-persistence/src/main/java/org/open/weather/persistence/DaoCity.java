package org.open.weather.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

class DaoCity implements Dao<DtoCity> {

  private ConnectionPool pool = ConnectionPoolImpl.getConnectionPool();

  @Override
  public void create(DtoCity cityDto) throws SQLException {
    String sql = "INSERT INTO CITIES (ID, NAME, COUNTRY) VALUES (?, ?, ?);";
    try (Connection conn = pool.getConnection();
        PreparedStatement stmn = conn.prepareStatement(sql);) {
      stmn.setInt(1, cityDto.getId());
      stmn.setString(2, cityDto.getName());
      stmn.setString(3, cityDto.getCountry());
      stmn.executeUpdate();
    }
  }

  @Override
  public DtoCity read(int id) throws SQLException {
    DtoCity city = null;
    String sql = "SELECT * FROM CITIES WHERE ID = ?";
    ResultSet rs = null;
    try (Connection conn = pool.getConnection();
        PreparedStatement stmn = conn.prepareStatement(sql);) {
      stmn.setInt(1, id);
      rs = stmn.executeQuery();
      rs.next();
      String name = rs.getString("NAME");
      String country = rs.getString("COUNTRY");
      city = new DtoCity(id, name, country);
    } finally {
      if (rs != null) {
        rs.close();
      }
    }
    return city;
  }

  @Override
  public void update(DtoCity cityDto) throws SQLException {
    String sql = "UPDATE CITIES SET NAME=?, COUNTRY=? WHERE ID=?";
    try (Connection conn = pool.getConnection();
        PreparedStatement stmn = conn.prepareStatement(sql);) {
      stmn.setString(1, cityDto.getName());
      stmn.setString(2, cityDto.getCountry());
      stmn.setInt(3, cityDto.getId());
      stmn.executeUpdate();
    }
  }

  @Override
  public void delete(int id) throws SQLException {
    String sql = "DELETE FROM CITIES WHERE ID=?";
    try (Connection conn = pool.getConnection();
        PreparedStatement stmn = conn.prepareStatement(sql);) {
      stmn.setInt(1, id);
      stmn.executeUpdate();
    }
  }

  @Override
  public List<DtoCity> search(String columnName, String substring) throws SQLException {
    List<DtoCity> cities = new ArrayList<>();
    String sql = String.format("SELECT * FROM CITIES WHERE " + columnName + " REGEXP %s;",
        "'.*" + substring + ".*'");
    ResultSet rs = null;
    try (Connection conn = pool.getConnection();
        PreparedStatement stmn = conn.prepareStatement(sql);) {
      rs = stmn.executeQuery();
      while (rs.next()) {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        String country = rs.getString("COUNTRY");
        cities.add(new DtoCity(id, name, country));
      }
    } finally {
      if (rs != null) {
        rs.close();
      }
    }
    return cities;
  }

}
