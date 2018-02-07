package space.vakar.weather.openweather.api;

import java.io.InputStream;

import space.vakar.weather.openweather.model.CurrentWeather;

public interface WeatherParser {

	public CurrentWeather parse(InputStream inputStream) throws Exception;

}
