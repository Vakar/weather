package space.vakar.weather.service.impl;

import com.google.gson.Gson;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import org.apache.log4j.Logger;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.service.api.WeatherContainer;

public class Container implements WeatherContainer {

  private static final Logger LOG = Logger.getLogger(Container.class);

  private Map<Integer, Weather> map = Collections.synchronizedMap(new TreeMap<>());

  private static final int MAX_CAPACITY = 1000;

  public Map<Integer, Weather> getMap() {
    return map;
  }

  public void setMap(Map<Integer, Weather> map) {
    this.map = map;
  }

  @Override
  public void push(Weather weather, int cityId) {
    validateNotNull(weather);
    cleanMapIfFull();
    LOG.debug("Push weather to container: " + new Gson().toJson(weather));
    map.put(cityId, weather);
  }

  private void validateNotNull(Weather weather) {
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
  public Weather pull(int cityId) {
    Weather weather = map.get(cityId);
    LOG.debug("Pull weather from container: " + new Gson().toJson(weather));
    return weather;
  }
}
