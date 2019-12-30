package space.vakar.weather.domain.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.Optional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.WeatherDto;

@RunWith(MockitoJUnitRunner.class)
public class WeatherAgentImplTest {

  private WeatherDto freshWeather;
  private WeatherDto notFreshWeather;
  
  private Optional<WeatherDto> freshWeatherOpt;
  private Optional<WeatherDto> notFreshWeatherOpt;

  private static final long NOW = System.currentTimeMillis();  
  private static final long ONE_MINUTE = 60 * 1000;
  private static final long MAX_ACTUAL_TIME = WeatherAgentImp.MAX_ACTUAL_TIME;
  private static final long MAX_ACTUAL_TIME_MINUS_1_MIN =  MAX_ACTUAL_TIME - ONE_MINUTE;
  private static final long MAX_ACTUAL_TIME_PLUS_1_MIN = MAX_ACTUAL_TIME + ONE_MINUTE;
  
  private static final int CITY_ID = 1;

  @Mock
  private WeatherContainer container;

  @Mock
  private WeatherProvider provider;
  
  @InjectMocks
  private WeatherAgentImp agent;

  @Before
  public void setUp() {
    freshWeather = EnhancedRandom.random(WeatherDto.class);
    freshWeather.setDt(NOW - MAX_ACTUAL_TIME_MINUS_1_MIN);
    freshWeatherOpt = Optional.of(freshWeather);
    notFreshWeather = EnhancedRandom.random(WeatherDto.class);
    notFreshWeather.setDt(NOW - MAX_ACTUAL_TIME_PLUS_1_MIN);
    notFreshWeatherOpt = Optional.of(notFreshWeather);
  }

  @Test
  public void shouldGetWeatherFromProvider_WhenWeatherFromContainerIsEmpty() {
    when(agent.getWeatherFromContainer(CITY_ID)).thenReturn(Optional.empty());
    when(agent.getWeatherFromProvider(CITY_ID)).thenReturn(freshWeatherOpt);
    assertEquals(freshWeatherOpt, agent.findWeatherForCityWithId(CITY_ID));
  }
  
  @Test
  public void shouldReturnEmptyOptionalFromContainer_WhenWeatherIsNotPersent() {
    when(container.pull(CITY_ID)).thenReturn(Optional.empty());
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromContainer(CITY_ID);
    assertEquals(Optional.empty(), actualWeatherOpt);
  }
  
  @Test
  public void shouldReturnEmptyOptionalFromContainer_WhenWeatherIsPersentButNotFresh() {
    when(container.pull(CITY_ID)).thenReturn(notFreshWeatherOpt);
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromContainer(CITY_ID);
    assertEquals(Optional.empty(), actualWeatherOpt);
  }

  @Test
  public void shouldReturnFullOptionalFromContainer_WhenWeatherIsPersentAndFresh() {
    when(container.pull(CITY_ID)).thenReturn(freshWeatherOpt);
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromContainer(CITY_ID);
    assertEquals(freshWeatherOpt, actualWeatherOpt);
  }
  
  @Test
  public void shouldReturnFullOptional_WhenWeatherIsPresent() {
    when(provider.provideWeatherForCityWithId(CITY_ID)).thenReturn(freshWeatherOpt);
    Optional<WeatherDto> actualWeatherOpt = agent.getWeatherFromProvider(CITY_ID);
    assertEquals(freshWeatherOpt, actualWeatherOpt);
  }
  
  @Test
  public void shouldPushWeatherIntoContainer_WhenWeatherIsPresent() {
    when(provider.provideWeatherForCityWithId(CITY_ID)).thenReturn(freshWeatherOpt);
    agent.getWeatherFromProvider(CITY_ID);
    verify(container).push(freshWeather);
  }

  @Test
  public void shouldReturnTrue_WhenWeatherFresh() {
    assertTrue(agent.isFresh.test(freshWeather));
  }

  @Test
  public void shouldReturnFalse_WhenWeatherNotFresh() {
    assertFalse(agent.isFresh.test(notFreshWeather));
  }
}
