package space.vakar.weather.domain.core;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import space.vakar.weather.domain.model.WeatherDto;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceImplTest {

  private WeatherDto weather = EnhancedRandom.random(WeatherDto.class);  
  private Optional<WeatherDto> weatherOpt = Optional.of(weather);
  
  private static final int CITY_ID = 1;

  @Mock
  private WeatherAgent agent;

  @InjectMocks
  private WeatherServiceImpl service;

  @Test
  public void shouldReturnWeather() {
    when(agent.getWeatherByCityId(CITY_ID)).thenReturn(weatherOpt);
    assertEquals(weatherOpt, service.weather(CITY_ID));
  }
}
