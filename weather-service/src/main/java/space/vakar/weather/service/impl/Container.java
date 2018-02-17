package space.vakar.weather.service.impl;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.WeatherContainer;

public class Container implements WeatherContainer{

  private Map<Integer, Weather> map = new TreeMap<>();

  public Map<Integer, Weather> getMap() {
    return map;
  }

  public void setMap(Map<Integer, Weather> map) {
    this.map = map;
  }

  @Override
  public void push(Weather weather, int cityId) {
    if (weather == null)
      throw new IllegalArgumentException();
    if (cityId < 0)
      throw new IllegalArgumentException();
    weather.setLastUpdate(LocalDateTime.now());
    map.put(cityId, weather);
  }

  @Override
  public Weather pull(int cityId) {
    return map.get(cityId);
  }

  @Override
  public boolean isExist(int cityId) {
    return map.containsKey(cityId);
  }

  @Override
  public boolean isFresh(int cityId) {
    // TODO Auto-generated method stub
    return false;
  }

}
