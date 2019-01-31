package space.vakar.open.weather.api;

import java.io.InputStream;

/** A set of methods for retrieving weather from OpenWeather server. */
public interface Retriever {

  /**
   * Ask OpenWeather server for XML data about current weather in city by id.
   *
   * @param cityId - special OpenWeather unique city id
   * @return {@link InputStream} with current weather data
   */
  InputStream weatherXml(int cityId);
}
