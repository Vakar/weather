package space.vakar.weather.domain.core;

import lombok.Getter;
import lombok.Setter;
import space.vakar.weather.domain.model.WeatherDto;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Getter
@Setter
class WeatherContainerImp implements WeatherContainer {

  private Map<Integer, WeatherDto> container = Collections.synchronizedMap(new TreeMap<>());

  private static final int MAX_CAPACITY = 1000;

  @Override
  public void push(WeatherDto weather) {
    cleanContainerIfItFull();
    container.put(weather.getId(), weather);
  }

  private void cleanContainerIfItFull() {
    if (container.size() >= MAX_CAPACITY) {
      container.clear();
    }
  }

  @Override
  public Optional<WeatherDto> pull(int cityId) {
    WeatherDto weather = container.get(cityId);
    return Optional.ofNullable(weather);
  }
}
