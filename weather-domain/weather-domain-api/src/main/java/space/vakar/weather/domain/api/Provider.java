package space.vakar.weather.domain.api;

import space.vakar.weather.domain.model.WeatherDto;

public interface Provider {

  /**
   * This method get city id and return {WeatherDto} with weather data.
   * 
   * @param cityId city id
   * @return {WeatherDto} with weather data
   */
  WeatherDto provideWeather(int cityId);
}
