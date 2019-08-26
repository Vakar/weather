package space.vakar.weather.domain.core;

import java.io.Serializable;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.domain.model.WeatherDto;

interface WeatherContainer extends Serializable {

  /**
   * Contain {@link Weather} objects and provide access to them.
   *
   * @param weather on the city
   * @param cityId is a unique number of city that used to represent weather for given city
   */
  void push(WeatherDto weather, int cityId);

  WeatherDto pull(int cityId);
}
