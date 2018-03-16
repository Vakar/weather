package space.vakar.weather.persistence.weather.api;

import space.vakar.weather.domain.model.weather.Weather;

public interface WeatherDao {

  void create(Weather weather);

  Weather read(int id);

  void update(Weather weather);

  void delete(int id);

}
