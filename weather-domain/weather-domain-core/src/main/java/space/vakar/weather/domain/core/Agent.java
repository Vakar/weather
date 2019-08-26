package space.vakar.weather.domain.core;

import space.vakar.weather.domain.model.WeatherDto;

interface Agent {

  WeatherDto weather(int cityId);

  boolean isFresh(WeatherDto weather);
}
