package space.vakar.weather.domain.core;

import java.io.Serializable;
import java.util.Optional;
import space.vakar.weather.domain.model.WeatherDto;

interface WeatherContainer extends Serializable {
  
  WeatherDto push(WeatherDto weather);

  Optional<WeatherDto> pull(int cityId);
}
