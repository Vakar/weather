package space.vakar.weather.domain.exceptions;

public class WeatherRetrieverException extends Exception {

  public WeatherRetrieverException(String message) {
    super(message);
  }

  public WeatherRetrieverException(String message, Throwable exception) {
    super(message, exception);
  }
}