package space.vakar.weather.provider.openweather.util.mappers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.testutils.CurrentWeatherPopulator;
import space.vakar.weather.provider.openweather.testutils.WeatherPopulator;


public class WeatherMapperTest {
	
	private Weather expectedWeather;
	private CurrentWeather currentWeather;
	
	@Before
	public void setUp() {
		expectedWeather = new Weather();
		WeatherPopulator.populate(expectedWeather);
		currentWeather = new CurrentWeather();
		CurrentWeatherPopulator.populateData(currentWeather);
	}

	@Test
	public void souldConvertProperly() {
		assertEquals(expectedWeather, GetWeather.from(currentWeather));
	}
}