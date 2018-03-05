package space.vakar.weather.provider.openweather.exceptions;

public class WeatherParserException extends Exception {

  public WeatherParserException(String message) {
    super(message);
  }

  public WeatherParserException(String message, Throwable exception) {
    super(message, exception);
  }

}
