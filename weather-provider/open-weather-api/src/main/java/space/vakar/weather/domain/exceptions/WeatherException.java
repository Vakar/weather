package space.vakar.weather.domain.exceptions;

public class WeatherException extends RuntimeException {
  public WeatherException(String message, Throwable exception) {
    super(message, exception);
  }
}
