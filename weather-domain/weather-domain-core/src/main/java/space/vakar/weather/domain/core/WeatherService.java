package space.vakar.weather.domain.core;

import java.util.Optional;
import space.vakar.weather.domain.model.WeatherDto;

public interface WeatherService {

  /**
   * This method get city id and return {WeatherDto} with weather data.
   * 
   * @param cityId city id
   * @return weather data transfer object
   */
  Optional<WeatherDto> findWeatherForCityWithId(int cityId);

  /**
   * This method calculates and returns the time remaining before the weather expiration in seconds.
   *
   * @param weather weather object
   * @return weather expire time in seconds
   */
  int calculateWeatherExpireTime(WeatherDto weather);
}
