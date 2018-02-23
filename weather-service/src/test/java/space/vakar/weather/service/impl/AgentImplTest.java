package space.vakar.weather.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.github.benas.randombeans.api.EnhancedRandom;
import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.provider.openweather.api.WeatherProvider;
import space.vakar.weather.service.api.WeatherContainer;

@RunWith(MockitoJUnitRunner.class)
public class AgentImplTest {

  private Weather freshWeather;
  private Weather notFreshWeather;
  
  private static final int CITY_ID = 1;

  @Mock
  private WeatherContainer container;

  @Mock
  private WeatherProvider provider;

  private AgentImpl agent;

  @Before
  public void setUpWeather() {
    freshWeather = EnhancedRandom.random(Weather.class);
    freshWeather.setLastUpdate(LocalDateTime.now().minusMinutes(30));
    notFreshWeather = EnhancedRandom.random(Weather.class);
    notFreshWeather.setLastUpdate(LocalDateTime.now().minusHours(2));
    agent = new AgentImpl(provider, container);
  }

  @Test
  public void shouldGetWeatherFromContainer_WhenWeatherInContainer() {
    when(container.pull(CITY_ID)).thenReturn(freshWeather);
    assertEquals(freshWeather, agent.weather(CITY_ID));
  }

  @Test
  public void shouldGetWeatherFromProvider_WhenWeatherNotInContainer() throws Exception {
    when(container.pull(CITY_ID)).thenReturn(null);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    assertEquals(freshWeather, agent.weather(CITY_ID));
  }

  @Test
  public void shouldPushWeatherIntoContainer_WhenWeatherNotInContainer() throws Exception {
    when(container.pull(CITY_ID)).thenReturn(null);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    agent.weather(CITY_ID);
    verify(container).push(freshWeather, CITY_ID);
  }

  @Test
  public void shouldGetWeatherFromProvider_WhenWeatherInContainerAndIsNotFresh() throws Exception {
    when(container.pull(CITY_ID)).thenReturn(notFreshWeather);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    assertEquals(freshWeather, agent.weather(CITY_ID));
  }

  @Test
  public void shouldPushWeatherIntoContainer_WhenWeatherInContaineAndIsNotFresh() throws Exception {
    when(container.pull(CITY_ID)).thenReturn(notFreshWeather);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    agent.weather(CITY_ID);
    verify(container).push(freshWeather, CITY_ID);
  }

  @Test
  public void shoulReturnTrue_WhenWeatherFresh() {
    assertTrue(agent.isFresh(freshWeather));
  }

  @Test
  public void shoulReturnFalse_WhenWeatherNotFresh() {
    assertFalse(agent.isFresh(notFreshWeather));
  }
}
