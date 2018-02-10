package space.vakar.weather.openweather.provider;

import org.junit.Test;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;

public class OpenWeatherProviderTest {

	WeatherProvider provider = new OpenWeatherProvider();
	
	// TODO
	@Test
	public void test() throws Exception {
		Weather weather = provider.provideWeather("Moncton");
		System.out.println(weather.toString());
	}

}
