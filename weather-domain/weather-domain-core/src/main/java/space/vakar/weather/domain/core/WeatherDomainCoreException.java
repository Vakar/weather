package space.vakar.weather.domain.core;

class WeatherDomainCoreException extends RuntimeException {

  public WeatherDomainCoreException(String message) {
    super(message);
  }

  WeatherDomainCoreException(String message, Throwable cause) {
    super(message, cause);
  }

}
