package space.vakar.weather.domain.api;

import space.vakar.weather.domain.model.weather.Weather;

public interface Agent {

  Weather weather(int cityId);

  boolean isFresh(Weather weather);
}
