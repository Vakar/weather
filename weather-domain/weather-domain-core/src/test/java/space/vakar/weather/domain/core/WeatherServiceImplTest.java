package space.vakar.weather.domain.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import space.vakar.weather.domain.model.WeatherDto;

@ExtendWith(MockitoExtension.class)
public class WeatherServiceImplTest {

  @Mock private WeatherAgent agent;

  @InjectMocks private WeatherServiceImpl service;

  @Test
  @DisplayName("when take valid city id as a parameter")
  public void shouldReturnWeather() {
    int cityId = 1;
    WeatherDto weather = EnhancedRandom.random(WeatherDto.class);
    Optional<WeatherDto> weatherOpt = Optional.of(weather);
    when(agent.findWeatherForCityWithId(cityId)).thenReturn(weatherOpt);
    assertEquals(
        weatherOpt,
        service.findWeatherForCityWithId(cityId),
        "should return optional with weather");
  }
}
