package space.vakar.weather.domain.core;

import com.google.gson.Gson;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import space.vakar.weather.domain.model.WeatherDto;

class WeatherContainerImpl implements WeatherContainer {

  private static final long serialVersionUID = -5406341995470471507L;

  private static final Logger LOG = LoggerFactory.getLogger(WeatherContainerImpl.class);

  private Map<Integer, WeatherDto> map = Collections.synchronizedMap(new TreeMap<>());

  private static final int MAX_CAPACITY = 1000;

  @Override
  public void push(WeatherDto weather, int cityId) {
    validateNotNull(weather);
    cleanMapIfFull();
    LOG.debug("Push weather to container: " + new Gson().toJson(weather));
    map.put(cityId, weather);
  }

  private void validateNotNull(WeatherDto weather) {
    if (weather == null) {
      throw new IllegalArgumentException();
    }
  }

  private void cleanMapIfFull() {
    if (map.size() >= MAX_CAPACITY) {
      map.clear();
    }
  }

  @Override
  public WeatherDto pull(int cityId) {
    WeatherDto weather = map.get(cityId);
    LOG.debug("Pull weather from container: " + new Gson().toJson(weather));
    return weather;
  }

  public Map<Integer, WeatherDto> getMap() {
    return map;
  }

  public void setMap(Map<Integer, WeatherDto> map) {
    this.map = map;
  }
}
