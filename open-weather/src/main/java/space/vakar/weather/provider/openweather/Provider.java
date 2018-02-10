package space.vakar.weather.provider.openweather;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.util.mappers.WeatherMapper;

public class Provider implements WeatherProvider {
	
	private Parser parser = new Parser();

	@Override
	public Weather provideWeather(String city) throws JAXBException, IOException {
		CurrentWeather currentWeather = parser.currentWeather(city);
		return WeatherMapper.from(currentWeather);
	}
}
