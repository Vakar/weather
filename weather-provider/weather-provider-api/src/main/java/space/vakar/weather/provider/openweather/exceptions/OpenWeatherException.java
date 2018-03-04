package space.vakar.weather.provider.openweather.exceptions;

public class OpenWeatherException extends RuntimeException {
  public OpenWeatherException(String message, Throwable e) {
    super(message, e);
  }
}
