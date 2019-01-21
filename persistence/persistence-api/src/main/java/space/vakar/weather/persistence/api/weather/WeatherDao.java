package space.vakar.weather.persistence.api.weather;

import java.util.List;

public interface WeatherDao<T> {

  T findOne(long id);

  List<T> findAll();

  void create(T entity);

  T update(T entity);

  void delete(T entity);

  void deleteById(long entityId);

}
