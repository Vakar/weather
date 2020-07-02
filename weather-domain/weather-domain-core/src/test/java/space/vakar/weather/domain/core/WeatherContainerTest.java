package space.vakar.weather.domain.core;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import space.vakar.weather.domain.model.WeatherDto;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherContainerTest {

  private final WeatherContainerImp container = new WeatherContainerImp();

  private static final int MAX_CONTAINER_SIZE = 1000;

  private static final int LONDON_ID = 1;
  private static final int TOKYO_ID = 2;
  private static final int PARIS_ID = 3;

  private final WeatherDto weatherInLondon = randomWeatherFor(LONDON_ID);
  private final WeatherDto weatherInTokyo = randomWeatherFor(TOKYO_ID);
  private final WeatherDto weatherInParis = randomWeatherFor(PARIS_ID);

  private WeatherDto randomWeatherFor(int cityId) {
    WeatherDto randomCity = EnhancedRandom.random(WeatherDto.class);
    randomCity.setId(cityId);
    return randomCity;
  }

  @BeforeEach
  public void setUpWeatherContainer() {
    Map<Integer, WeatherDto> map = new TreeMap<>();
    map.put(weatherInLondon.getId(), weatherInLondon);
    map.put(weatherInTokyo.getId(), weatherInTokyo);
    container.setContainer(map);
  }

  @Test
  @DisplayName("when push weather to container")
  public void shouldSaveWeather() {
    container.push(weatherInParis);
    WeatherDto actual = container.getContainer().get(PARIS_ID);
    assertEquals(weatherInParis, actual, "should save weather inside container");
  }

  @Test
  @DisplayName(
      "when weather for given city id already inside container and you push new weather with same city id ")
  public void shouldReplaceOldWeather() {
    WeatherDto newWeatherInLondon = randomWeatherFor(LONDON_ID);
    container.push(newWeatherInLondon);
    WeatherDto actual = container.getContainer().get(LONDON_ID);
    assertEquals(newWeatherInLondon, actual, "should replace old weather with new weather");
  }

  @Test
  @DisplayName("when container overload")
  public void containerCapacity() {
    container.setContainer(new TreeMap<>());
    for (int i = 0; i < MAX_CONTAINER_SIZE + 1; i++) {
      weatherInLondon.setId(i);
      container.push(weatherInLondon);
    }
    int actualContainerSize = this.container.getContainer().size();
    assertTrue(
        actualContainerSize <= MAX_CONTAINER_SIZE,
        "container capacity should not be bigger than " + MAX_CONTAINER_SIZE);
  }

  @Test
  @DisplayName("when weather for given city id exists inside weather container")
  public void weatherInsideContainer() {
    Optional<WeatherDto> actual = container.pull(TOKYO_ID);
    assertEquals(Optional.of(weatherInTokyo), actual, "should return weather optional");
  }

  @Test
  @DisplayName("when weather for given city id doesn't exist")
  public void noWeatherInsideContainer() {
    Optional<WeatherDto> actual = container.pull(PARIS_ID);
    assertEquals(Optional.empty(), actual, "should return empty optional");
  }
}
