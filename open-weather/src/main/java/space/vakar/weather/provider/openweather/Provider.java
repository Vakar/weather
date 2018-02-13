package space.vakar.weather.provider.openweather;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.util.mappers.GetWeather;

public class Provider implements WeatherProvider {
	
	private Parser parser = new Parser();

	@Override
	public Weather provideWeather(String city) {
		CurrentWeather currentWeather;
		try {
			currentWeather = parser.currentWeather(city);
		} catch (JAXBException e) {
			throw new OpenWeatherException("Can't parse input stream");
		} catch (IOException e) {
			throw new OpenWeatherException("Can't get stream from server");
		}
		return GetWeather.from(currentWeather);
	}
}
