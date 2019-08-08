package space.vakar.open.weather.provider;

class OpenWeatherException extends RuntimeException {
  OpenWeatherException(String message, Throwable exception) {
    super(message, exception);
  }

  OpenWeatherException(String message) {
    super(message);
  }
}
