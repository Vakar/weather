package space.vakar.weather.service.api;

import space.vakar.weather.domain.model.weather.Weather;

public interface WeatherService {

  public Weather weather(int cityId);

}
