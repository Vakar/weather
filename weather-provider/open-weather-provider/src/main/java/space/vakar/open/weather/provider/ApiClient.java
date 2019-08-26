package space.vakar.open.weather.provider;

/** A set of methods for retrieving weather from OpenWeather server. */
interface ApiClient {

  /** 
   * Ask OpenWeather server for JSON data about current weather in city by id.
   * 
   * @param cityId - special OpenWeather unique city id
   * @return - current weather for city in JSON format
   */
  String getCityWeatherJsonByCityId(int cityId);
}
