package space.vakar.weather.provider.openweather.util.mappers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.testutils.CurrentWeatherPopulator;
import space.vakar.weather.provider.openweather.testutils.WeatherPopulator;


public class WeatherMapperTest {

	@Test
	public void test() {
		Weather expectedWeather = new Weather();
		WeatherPopulator.populate(expectedWeather);
		CurrentWeather currentWeather = new CurrentWeather();
		CurrentWeatherPopulator.populate(currentWeather);
		Weather weather = WeatherMapper.from(currentWeather);
		assertEquals(expectedWeather, weather);
	}
}