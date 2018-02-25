package space.vakar.weather.provider.openweather.exceptions;

public class OpenWeatherParserException extends Exception {

  public OpenWeatherParserException(String message) {
    super(message);
  }

  public OpenWeatherParserException(String message, Throwable e) {
    super(message, e);
  }

}
