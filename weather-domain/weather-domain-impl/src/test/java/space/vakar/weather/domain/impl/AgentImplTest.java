package space.vakar.weather.domain.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.open.weather.api.Provider;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.domain.api.WeatherContainer;

@RunWith(MockitoJUnitRunner.class)
public class AgentImplTest {

  private Weather freshWeather;
  private Weather notFreshWeather;

  private static final int CITY_ID = 1;

  @Mock private WeatherContainer container;

  @Mock private Provider provider;

  private AgentImpl agent;

  @Before
  public void setUpWeather() {
    ZoneId utc = ZoneId.of("UTC");
    freshWeather = EnhancedRandom.random(Weather.class);
    freshWeather.setMeasuringTime(LocalDateTime.now(utc).minusMinutes(30));
    notFreshWeather = EnhancedRandom.random(Weather.class);
    notFreshWeather.setMeasuringTime(LocalDateTime.now(utc).minusHours(2));
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
  public void shouldPushWeatherIntoContainer_WhenWeatherInContaineAndIsNotFresh() {
    when(container.pull(CITY_ID)).thenReturn(notFreshWeather);
    when(provider.provideWeather(CITY_ID)).thenReturn(freshWeather);
    agent.weather(CITY_ID);
    verify(container).push(freshWeather, CITY_ID);
  }

  @Test
  public void shouldReturnNull_WhenProviderReturnNull(){
    when(provider.provideWeather(CITY_ID)).thenReturn(null);
    assertNull(agent.weather(CITY_ID));
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
