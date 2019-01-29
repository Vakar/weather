package space.vakar.weather.domain.api;

import space.vakar.weather.domain.model.weather.Weather;

public interface WeatherService {

  public Weather weather(int cityId);
}
