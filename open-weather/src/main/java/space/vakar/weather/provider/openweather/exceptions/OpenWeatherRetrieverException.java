package space.vakar.weather.provider.openweather.exceptions;

public class OpenWeatherRetrieverException extends Exception {

  public OpenWeatherRetrieverException(String message) {
    super(message);
  }

  public OpenWeatherRetrieverException(String message, Throwable e) {
    super(message, e);
  }

}
