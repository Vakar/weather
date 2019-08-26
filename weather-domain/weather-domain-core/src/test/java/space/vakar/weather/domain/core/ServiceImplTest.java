package space.vakar.weather.domain.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import io.github.benas.randombeans.api.EnhancedRandom;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import space.vakar.weather.domain.core.WeatherServiceImpl;
import space.vakar.weather.domain.model.WeatherDto;

@RunWith(MockitoJUnitRunner.class)
public class ServiceImplTest {

  private WeatherDto weather;

  @Mock
  private Agent agent;

  private WeatherServiceImpl service;

  @Before
  public void setUp() {
    weather = EnhancedRandom.random(WeatherDto.class);
    service = new WeatherServiceImpl(agent);
  }

  @Test
  public void shouldReturnWeather() {
    when(agent.weather(1)).thenReturn(weather);
    assertEquals(weather, service.weather(1));
  }
}
