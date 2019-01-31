package space.vakar.open.weather.api;

import space.vakar.weather.domain.model.weather.Weather;

public interface Provider {

  Weather provideWeather(int cityId);
}
