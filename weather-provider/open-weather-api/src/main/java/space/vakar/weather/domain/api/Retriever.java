package space.vakar.weather.domain.api;

import java.io.InputStream;
import space.vakar.weather.domain.exceptions.WeatherRetrieverException;

/** A set of methods for retrieving weather from OpenWeather server. */
public interface Retriever {

  /**
   * Ask OpenWeather server for XML data about current weather in city by id.
   *
   * @param cityId - special OpenWeather unique city id
   * @return {@link InputStream} with current weather data
   * @throws WeatherRetrieverException OpenWeatherException in case of a not valid request <code>URL
   *     </code> or in case of a connection problem or the connection was aborted
   */
  InputStream weatherXml(int cityId) throws WeatherRetrieverException;
}