package space.vakar.weather.provider.openweather.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.provider.openweather.impl.Parser;
import space.vakar.weather.provider.openweather.impl.Provider;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.testutils.CurrentWeatherPopulator;
import space.vakar.weather.provider.openweather.testutils.WeatherPopulator;

@RunWith(MockitoJUnitRunner.class)
public class ProviderTest {
	
	@Mock
	Parser parserMock;

	@InjectMocks
	Provider provider;
	
	Weather expectedWeather;
	CurrentWeather currentWeather;
	
	@Before
	public void setUp() throws IOException {
		currentWeather = new CurrentWeather();
		CurrentWeatherPopulator.populateData(currentWeather);
		expectedWeather = new Weather();
		WeatherPopulator.populate(expectedWeather);
	}

	@Test
	public void test() throws Exception {
		when(parserMock.weather(6076211)).thenReturn(currentWeather);	
		Weather weather = provider.provideWeather(6076211);
		assertEquals(expectedWeather, weather);
	}

}
