package space.vakar.weather.domain.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import io.github.benas.randombeans.api.EnhancedRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import space.vakar.weather.domain.api.Provider;
import space.vakar.weather.domain.core.AgentImpl;
import space.vakar.weather.domain.model.WeatherDto;

@RunWith(MockitoJUnitRunner.class)
public class AgentImplTest {

  private WeatherDto freshWeather;
  private WeatherDto notFreshWeather;

  private static final long NOW = System.currentTimeMillis();
  private static final int MINUTES_30 = 1000 * 60 * 30;
  private static final int MINUTES_120 = 1000 * 60 * 121;

  private static final int CITY_ID = 1;

  @Mock
  private WeatherContainer container;

  @Mock
  private Provider provider;

  private AgentImpl agent;

  @Before
  public void setUpWeather() {
    freshWeather = EnhancedRandom.random(WeatherDto.class);
    freshWeather.setDt(NOW - MINUTES_30);
    notFreshWeather = EnhancedRandom.random(WeatherDto.class);
    notFreshWeather.setDt(NOW - MINUTES_120);
    agent = new AgentImpl(provider, container);
  }

  @Test
  public void shouldGetWeatherFromContainer_WhenWeatherInContainer() {
    when(container.pull(CITY_ID)).thenReturn(freshWeather);
    assertEquals(freshWeather, agent.weather(CITY_ID));
  }

  @Test
  public void shouldGetWeatherFromProvider_WhenWeatherNotInContainer() {
    when(container.pull(CITY_ID)).thenReturn(null);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    assertEquals(freshWeather, agent.weather(CITY_ID));
  }

  @Test
  public void shouldPushWeatherIntoContainer_WhenWeatherNotInContainer() {
    when(container.pull(CITY_ID)).thenReturn(null);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    agent.weather(CITY_ID);
    verify(container).push(freshWeather, CITY_ID);
  }

  @Test
  public void shouldGetWeatherFromProvider_WhenWeatherInContainerAndIsNotFresh() {
    when(container.pull(CITY_ID)).thenReturn(notFreshWeather);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    assertEquals(freshWeather, agent.weather(CITY_ID));
  }

  @Test
  public void shouldPushWeatherIntoContainer_WhenWeatherInContainerAndIsNotFresh() {
    when(container.pull(CITY_ID)).thenReturn(notFreshWeather);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    agent.weather(CITY_ID);
    verify(container).push(freshWeather, CITY_ID);
  }

  @Test
  public void shouldReturnNull_WhenProviderReturnNull() {
    when(provider.provideWeather(CITY_ID)).thenReturn(null);
    assertNull(agent.weather(CITY_ID));
  }

  @Test
  public void shouldReturnTrue_WhenWeatherFresh() {
    assertTrue(agent.isFresh(freshWeather));
  }

  @Test
  public void shouldReturnFalse_WhenWeatherNotFresh() {
    assertFalse(agent.isFresh(notFreshWeather));
  }
}
