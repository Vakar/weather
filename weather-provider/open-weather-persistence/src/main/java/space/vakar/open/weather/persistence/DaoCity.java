package space.vakar.open.weather.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.dbcp.BasicDataSource;
import space.vakar.weather.domain.model.City;

class DaoCity implements Dao<City> {

  private static final String FIELD_ID = "ID";
  private static final String FIELD_NAME = "NAME";
  private static final String FIELD_COUNTRY = "COUNTRY";

  private BasicDataSource dataSource = DbcpDataSource.getDataSource();

  @Override
  public void create(City city) throws SQLException {
    String sql = "INSERT INTO CITIES (ID, NAME, COUNTRY) VALUES (?, ?, ?);";
    try (Connection conn = dataSource.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql)) {
      stm.setInt(1, city.getId());
      stm.setString(2, city.getName());
      stm.setString(3, city.getCountry());
      stm.executeUpdate();
    }
  }

  @Override
  public City read(int id) throws SQLException {
    City city = new City();
    String sql = "SELECT * FROM CITIES WHERE ID = ?;";
    ResultSet rs = null;
    try (Connection conn = dataSource.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql)) {
      stm.setInt(1, id);
      rs = stm.executeQuery();
      if (rs.first()) {
        String name = rs.getString(FIELD_NAME);
        String country = rs.getString(FIELD_COUNTRY);
        city = new City(id, name, country);
      }
    } finally {
      if (rs != null) {
        rs.close();
      }
    }
    return city;
  }

  @Override
  public void update(City city) throws SQLException {
    String sql = "UPDATE CITIES SET NAME=?, COUNTRY=? WHERE ID=?;";
    try (Connection conn = dataSource.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql)) {
      stm.setString(1, city.getName());
      stm.setString(2, city.getCountry());
      stm.setInt(3, city.getId());
      stm.executeUpdate();
    }
  }

  @Override
  public void delete(int id) throws SQLException {
    String sql = "DELETE FROM CITIES WHERE ID=?;";
    try (Connection conn = dataSource.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql)) {
      stm.setInt(1, id);
      stm.executeUpdate();
    }
  }

  @Override
  public List<City> search(String columnName, String substring) throws SQLException {
    List<City> cities = new ArrayList<>();
    String sql = "SELECT * FROM CITIES WHERE " + columnName + " LIKE '%" + substring + "%';";
    try (Connection conn = dataSource.getConnection();
        PreparedStatement stm = conn.prepareStatement(sql);
        ResultSet rs = stm.executeQuery()) {
      while (rs.next()) {
        int id = rs.getInt(FIELD_ID);
        String name = rs.getString(FIELD_NAME);
        String country = rs.getString(FIELD_COUNTRY);
        cities.add(new City(id, name, country));
      }
    }
    return cities;
  }
}
