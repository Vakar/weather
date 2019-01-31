package space.vakar.open.weather.impl;

public class OpenWeatherException extends RuntimeException {
  public OpenWeatherException(String message, Throwable exception) {
    super(message, exception);
  }

  public OpenWeatherException(String message) {
    super(message);
  }
}
