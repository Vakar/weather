package space.vakar.weather.provider.openweather.api;

import java.io.IOException;
import java.io.InputStream;

import space.vakar.weather.provider.openweather.OpenWeatherException;

/**
 * A set of methods for retrieving weather from OpenWeather server.
 */
public interface WeatherRetriever {

	/**
	 * Ask OpenWeather server for XML data about current weather in city by id
	 * @param cityId - special OpenWeather unique city id
	 * @return {@link InputStream} with current weather data
	 * @throws IOException in case of a connection problem or the connection was aborted
	 * @throws OpenWeatherException in case of a not valid request <code>URL</code>
	 */
	public InputStream weatherXML(int cityId) throws IOException, OpenWeatherException;
}