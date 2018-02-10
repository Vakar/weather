package space.vakar.weather.provider.openweather;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.provider.openweather.api.WeatherRetriever;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.util.mappers.WeatherMapper;

public class Provider implements WeatherProvider {
	
	WeatherRetriever retriever = new Retriever();

	@Override
	public Weather provideWeather(String city) throws JAXBException, IOException {
		InputStream in = retriever.getWeatherXML(city);
		CurrentWeather weather = Parser.parse(in);
		return WeatherMapper.from(weather);
	}

}
