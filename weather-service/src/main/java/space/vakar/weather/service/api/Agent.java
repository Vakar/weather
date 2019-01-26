package space.vakar.weather.service.api;

import space.vakar.weather.domain.model.weather.Weather;

public interface Agent {

  public Weather weather(int cityId);

  public boolean isFresh(Weather weather);
}
