package space.vakar.weather.provider.openweather;

import org.junit.Test;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.provider.openweather.Provider;

public class OpenWeatherProviderTest {

	WeatherProvider provider = new Provider();
	
	// TODO
	@Test
	public void test() throws Exception {
		Weather weather = provider.provideWeather("Moncton");
		System.out.println(weather.toString());
	}

}
