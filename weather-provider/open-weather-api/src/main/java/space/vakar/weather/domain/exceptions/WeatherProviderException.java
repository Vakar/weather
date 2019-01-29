package space.vakar.weather.domain.exceptions;

public class WeatherProviderException extends Exception {

  public WeatherProviderException(String message, Throwable exception) {
    super(message, exception);
  }
}
