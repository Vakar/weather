package space.vakar.open.weather.exception;

public class OpenWeatherException extends RuntimeException {
  public OpenWeatherException(String message, Throwable exception) {
    super(message, exception);
  }
}
