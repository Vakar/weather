package space.vakar.open.weather.persistence;

import java.sql.SQLException;
import java.util.List;

interface Dao<T extends Entity> {

  void create(T entity) throws SQLException;

  T read(int id) throws SQLException;

  void update(T entity) throws SQLException;

  void delete(int id) throws SQLException;

  List<T> search(String columnName, String substring) throws SQLException;

}
