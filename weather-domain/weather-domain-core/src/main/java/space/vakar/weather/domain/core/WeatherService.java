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
  Optional<WeatherDto> weather(int cityId);
}
