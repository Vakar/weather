package space.vakar.weather.domain.core;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.WeatherDto;

@ExtendWith(MockitoExtension.class)
public class WeatherAgentImplTest {

  private WeatherDto freshWeather;
  private WeatherDto notFreshWeather;

  private Optional<WeatherDto> freshWeatherOpt;
  private Optional<WeatherDto> notFreshWeatherOpt;

  private static final long NOW = System.currentTimeMillis();
  private static final long ONE_MINUTE = 60 * 1000;
  private static final long MAX_ACTUAL_TIME = WeatherAgentImp.MAX_ACTUAL_TIME;
  private static final long MAX_ACTUAL_TIME_MINUS_1_MIN = MAX_ACTUAL_TIME - ONE_MINUTE;
  private static final long MAX_ACTUAL_TIME_PLUS_1_MIN = MAX_ACTUAL_TIME + ONE_MINUTE;

  private static final int CITY_ID = 1;

  @Mock private WeatherContainer container;

  @Mock private WeatherProvider provider;

  @InjectMocks private WeatherAgentImp agent;

  @BeforeEach
  public void setUp() {
    freshWeather = EnhancedRandom.random(WeatherDto.class);
    freshWeather.setDt(NOW - MAX_ACTUAL_TIME_MINUS_1_MIN);
    freshWeatherOpt = Optional.of(freshWeather);
    notFreshWeather = EnhancedRandom.random(WeatherDto.class);
    notFreshWeather.setDt(NOW - MAX_ACTUAL_TIME_PLUS_1_MIN);
    notFreshWeatherOpt = Optional.of(notFreshWeather);
  }

  @Test
  @DisplayName("when weather from container is empty")
  public void shouldGetWeatherFromProvider_WhenWeatherFromContainerIsEmpty() {
    when(agent.getWeatherFromContainer(CITY_ID)).thenReturn(Optional.empty());
    when(agent.getWeatherFromProvider(CITY_ID)).thenReturn(freshWeatherOpt);
    Optional<WeatherDto> actual = agent.findWeatherForCityWithId(CITY_ID);
    assertEquals(freshWeatherOpt, actual, "should get weather from provider");
  }

  @Test
  @DisplayName("when weather is not present inside container")
  public void noWeatherInsideContainer() {
    when(container.pull(CITY_ID)).thenReturn(Optional.empty());
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromContainer(CITY_ID);
    assertEquals(Optional.empty(), actualWeatherOpt, "should return empty optional");
  }

  @Test
  @DisplayName("when weather is present in container but not fresh")
  public void notFreshWeatherInsideContainer() {
    when(container.pull(CITY_ID)).thenReturn(notFreshWeatherOpt);
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromContainer(CITY_ID);
    assertEquals(Optional.empty(), actualWeatherOpt, "should return empty optional");
  }

  @Test
  @DisplayName("when agent get weather from container")
  public void getWeatherFromContainer() {
    when(container.pull(CITY_ID)).thenReturn(freshWeatherOpt);
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromContainer(CITY_ID);
    assertEquals(freshWeatherOpt, actualWeatherOpt, "should return weather optional");
  }

  @Test
  @DisplayName("when agent get weather from provider should return weather optional")
  public void getWeatherFromProvider() {
    when(provider.provideWeatherForCityWithId(CITY_ID)).thenReturn(freshWeatherOpt);
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromProvider(CITY_ID);
    assertEquals(freshWeatherOpt, actualWeatherOpt, "should return weather optional");
  }

  @Test
  @DisplayName("when agent get weather from provider should push it into container")
  public void pushWeatherIntoContainer() {
    when(provider.provideWeatherForCityWithId(CITY_ID)).thenReturn(freshWeatherOpt);
    agent.getWeatherFromProvider(CITY_ID);
    verify(container).push(freshWeather);
  }

  @Test
  @DisplayName("when weather fresh")
  public void weatherIsFresh() {
    assertTrue(agent.isFresh.test(freshWeather), "should return true");
  }

  @Test
  @DisplayName("when weather not fresh")
  public void weatherIsNotFresh() {
    assertFalse(agent.isFresh.test(notFreshWeather), "should return false");
  }
}
