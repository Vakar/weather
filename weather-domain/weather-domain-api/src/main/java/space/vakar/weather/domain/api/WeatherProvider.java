package space.vakar.weather.domain.api;

import java.util.Optional;
import space.vakar.weather.domain.model.WeatherDto;

public interface WeatherProvider {

  /**
   * This method get city id and return {WeatherDto} with weather data.
   * 
   * @param cityId city id
   * @return {WeatherDto} with weather data or null if something goes wrong
   */
  Optional<WeatherDto> provideWeather(int cityId);
}
