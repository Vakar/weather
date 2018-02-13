package space.vakar.weather.provider.openweather.util.mappers;

import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.domain.model.temperature.Temperature;
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

	// TODO create test
	@Test
	public void test() {
//		assertEquals(expectedWeather, GetWeather.from(currentWeather));
		System.out.println(new Temperature().toString());
		fail("Not yet implemented");
	}
	
	@Test
	public void shouldConvertNullValuesToDefaultNotNull() {
		System.out.println(currentWeather.toString());
		currentWeather.setTemperature(null);
		System.out.println(currentWeather.toString());
		GetWeather.from(currentWeather);
		fail("Not yet implemented");
	}
}