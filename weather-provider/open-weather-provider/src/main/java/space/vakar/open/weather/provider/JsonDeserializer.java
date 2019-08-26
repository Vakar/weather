package space.vakar.open.weather.provider;

import com.google.gson.Gson;
import space.vakar.weather.domain.model.WeatherDto;

class JsonDeserializer {

  private static final String SHOULD_NOT_BE_NULL_MESSAGE = "Weather JSON should not be null!";
  private static final String SHOULD_NOT_BE_BLANK_MESSAGE =
      "Weather JSON should not be blank or empty string!";

  private JsonDeserializer() {
    throw new IllegalStateException("Utility class");
  }

  static WeatherDto convertJsonToWeatherDto(String weatherJson) {
    if (weatherJson == null) {
      throw new IllegalArgumentException(SHOULD_NOT_BE_NULL_MESSAGE);
    }
    weatherJson = weatherJson.trim();
    if (weatherJson.equals("")) {
      throw new IllegalArgumentException(SHOULD_NOT_BE_BLANK_MESSAGE);
    }
    return new Gson().fromJson(weatherJson, WeatherDto.class);
  }
}
