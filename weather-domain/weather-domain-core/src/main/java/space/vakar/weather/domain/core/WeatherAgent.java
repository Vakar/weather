package space.vakar.weather.domain.core;

import java.util.Optional;
import space.vakar.weather.domain.model.WeatherDto;

interface WeatherAgent {

  Optional<WeatherDto> findWeatherForCityWithId(int cityId);
  
}
