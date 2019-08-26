package space.vakar.weather.domain.core;

class WeatherServiceException extends RuntimeException {

  WeatherServiceException(String message, Throwable cause) {
    super(message, cause);
  }
}
