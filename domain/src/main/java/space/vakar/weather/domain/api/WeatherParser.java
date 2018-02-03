package space.vakar.weather.domain.api;

import java.io.InputStream;

import space.vakar.weather.domain.Weather;

public interface WeatherParser {

	public Weather parse(InputStream inputStream);

}
