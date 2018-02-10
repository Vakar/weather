package space.vakar.weather.provider.openweather.api;

import java.io.IOException;
import java.io.InputStream;

public interface WeatherRetriever {
	public InputStream getWeatherXML(String cityId) throws IOException;
}