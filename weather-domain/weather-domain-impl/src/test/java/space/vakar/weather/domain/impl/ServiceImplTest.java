package space.vakar.weather.domain.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import io.github.benas.randombeans.api.EnhancedRandom;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.domain.api.Agent;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTest {

  private Weather weather;

  @Mock private Agent agent;

  private WeatherServiceImpl service;

  @Before
  public void setUp() {
    weather = EnhancedRandom.random(Weather.class);
    service = new WeatherServiceImpl(agent);
  }

  @Test
  public void shouldReturnWeather() {
    when(agent.weather(1)).thenReturn(weather);
    assertEquals(weather, service.weather(1));
  }
}