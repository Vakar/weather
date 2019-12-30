package space.vakar.weather.domain.core;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;
import space.vakar.weather.domain.model.WeatherDto;

import static org.junit.Assert.*;

public class WeatherContainerTest {

  private WeatherContainerImp container;

  private static final int WEATHER_A_CITY_ID = 1;
  private static final int WEATHER_B_CITY_ID = 2;
  private static final int WEATHER_C_CITY_ID = 3;
  private static final int MAX_CONTAINER_SIZE = 1000;

  private WeatherDto weatherA = EnhancedRandom.random(WeatherDto.class);
  private WeatherDto weatherB = EnhancedRandom.random(WeatherDto.class);
  private WeatherDto weatherC = EnhancedRandom.random(WeatherDto.class);

  @Before
  public void setUp() {
    weatherA.setId(WEATHER_A_CITY_ID);
    weatherB.setId(WEATHER_B_CITY_ID);
    weatherC.setId(WEATHER_C_CITY_ID);
    container = new WeatherContainerImp();
    Map<Integer, WeatherDto> map = new TreeMap<>();
    map.put(weatherA.getId(), weatherA);
    map.put(weatherB.getId(), weatherB);
    container.setContainer(map);
  }

  @Test
  public void shouldPutObjectToContainer_WhenPushObjectNotNullValid() {
    container.push(weatherC);
    assertEquals(weatherC, container.getContainer().get(WEATHER_C_CITY_ID));
  }

  @Test
  public void shouldReplaceOldObjectFromContainer_WhenObjectWithTheSameCityIdExist() {
    WeatherDto newWeatherA = EnhancedRandom.random(WeatherDto.class);
    newWeatherA.setId(WEATHER_A_CITY_ID);
    container.push(newWeatherA);
    assertEquals(newWeatherA, container.getContainer().get(WEATHER_A_CITY_ID));
  }

  @Test
  public void containerCapacityShouldNotBeBiggerThan1000() {
    container.setContainer(new TreeMap<>());
    for (int i = 0; i < MAX_CONTAINER_SIZE + 1; i++) {
      weatherA.setId(i);
      container.push(weatherA);
    }
    assertTrue(this.container.getContainer().size() <= MAX_CONTAINER_SIZE);
  }

  @Test
  public void shouldReturnWeatherByCityId_WhenExists() {
    assertEquals(Optional.ofNullable(weatherB), container.pull(WEATHER_B_CITY_ID));
  }

  @Test
  public void shouldReturnNull_WhenNotExist() {
    assertEquals(Optional.empty(), container.pull(WEATHER_C_CITY_ID));
  }
}
