package space.vakar.weather.domain.api;

import space.vakar.weather.domain.model.weather.Weather;

public interface WeatherService {

  Weather weather(int cityId);
}
