package space.vakar.weather.domain.core;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import space.vakar.weather.domain.model.WeatherDto;

class WeatherContainerImp implements WeatherContainer {

  private Map<Integer, WeatherDto> map = Collections.synchronizedMap(new TreeMap<>());

  private static final int MAX_CAPACITY = 1000;

  @Override
  public WeatherDto push(WeatherDto weather) {
    cleanMapIfFull();
    return map.put(weather.getId(), weather);
  }

  private void cleanMapIfFull() {
    if (map.size() >= MAX_CAPACITY) {
      map.clear();
    }
  }

  @Override
  public Optional<WeatherDto> pull(int cityId) {
    WeatherDto weather = map.get(cityId);
    return Optional.ofNullable(weather);
  }

  public Map<Integer, WeatherDto> getMap() {
    return map;
  }

  public void setMap(Map<Integer, WeatherDto> map) {
    this.map = map;
  }

}
