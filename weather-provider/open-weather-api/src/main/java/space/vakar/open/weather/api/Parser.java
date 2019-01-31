package space.vakar.open.weather.api;

/** A set of methods for parsing weather from OpenWeather source. */
public interface Parser<T> {

  /**
   * Unmarshal OpenWeather current weather from XML to T using JAXB with schema
   * validation.
   *
   * @param cityId special OpenWeather unique city id
   * @return instance with data about current weather
   */
  T weather(int cityId);
}
