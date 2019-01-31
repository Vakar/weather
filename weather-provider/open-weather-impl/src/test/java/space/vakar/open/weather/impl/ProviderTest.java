package space.vakar.open.weather.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.open.weather.model.CurrentWeather;
import space.vakar.open.weather.testutils.CurrentWeatherPopulator;
import space.vakar.open.weather.testutils.WeatherPopulator;
import space.vakar.weather.domain.model.weather.Weather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProviderTest {

  @Mock
  ParserImpl parserMock;

  @InjectMocks
  ProviderImpl provider;

  Weather expectedWeather;
  CurrentWeather currentWeather;

  @Before
  public void setUp() {
    currentWeather = new CurrentWeather();
    CurrentWeatherPopulator.populateData(currentWeather);
    expectedWeather = new Weather();
    WeatherPopulator.populate(expectedWeather);
  }

  @Test
  public void provideWeather(){
    when(parserMock.weather(6076211)).thenReturn(currentWeather);
    Weather actualWeather = provider.provideWeather(6076211);
    assertEquals(expectedWeather, actualWeather);
  }

  @Test
  public void shouldReturnNull_WhenInputBelowZero(){
    Weather weather = provider.provideWeather(-1);
    assertNull(weather);
  }

}
