package space.vakar.weather.domain.core;

public class WeatherServiceException extends RuntimeException {

  public WeatherServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}
