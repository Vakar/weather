package space.vakar.weather.openweather.api;

import java.io.InputStream;

import space.vakar.weather.domain.Weather;

public interface WeatherParser {

	public Weather parse(InputStream inputStream) throws Exception;

}
