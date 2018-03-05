package space.vakar.weather.provider.openweather.exceptions;

public class WeatherException extends RuntimeException {
  public WeatherException(String message, Throwable exception) {
    super(message, exception);
  }
}
