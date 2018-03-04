package space.vakar.weather.provider.openweather.api;

import space.vakar.weather.provider.openweather.exceptions.OpenWeatherParserException;

/**
 * A set of methods for parsing weather from OpenWeather source to {@link CurrentWeather}.
 */
public interface Parser<T> {

  /**
   * Unmarshal OpenWeather current weather from XML to {@link CurrentWeather} using JAXB with schema
   * validation.
   *
   * @param cityId special OpenWeather unique city id
   * @return {@link CurrentWeather} instance with data about current weather
   * @throws OpenWeatherParserException if can't parse xml file from server
   */
  public T weather(int cityId) throws OpenWeatherParserException;

}
