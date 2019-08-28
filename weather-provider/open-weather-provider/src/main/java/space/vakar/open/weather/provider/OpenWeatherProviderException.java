package space.vakar.open.weather.provider;

class OpenWeatherProviderException extends RuntimeException {
  OpenWeatherProviderException(String message, Throwable exception) {
    super(message, exception);
  }

  OpenWeatherProviderException(String message) {
    super(message);
  }
}
