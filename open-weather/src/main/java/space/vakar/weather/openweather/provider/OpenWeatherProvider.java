package space.vakar.weather.openweather.provider;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.openweather.api.WeatherRetriever;
import space.vakar.weather.openweather.model.CurrentWeather;
import space.vakar.weather.openweather.util.WeatherMapper;

public class OpenWeatherProvider implements WeatherProvider {
	
	WeatherRetriever retriever = new OpenWeatherRetriever(); 

	@Override
	public Weather provideWeather(String city) throws JAXBException, IOException {
		InputStream in = retriever.getWeatherXML(city);
		CurrentWeather weather = OpenWeatherParser.parse(in);
		return WeatherMapper.from(weather);
	}

}
