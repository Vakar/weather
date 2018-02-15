package space.vakar.weather.provider.openweather;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.util.mappers.GetWeather;

public class Provider implements WeatherProvider {

	private Parser parser = new Parser();

	@Override
	public Weather provideWeather(int city) {
		CurrentWeather currentWeather = parser.weather(city);
		return GetWeather.from(currentWeather);
	}
}
