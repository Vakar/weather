package space.vakar.open.weather.persistence;

class OpenWeatherPersistenceException extends RuntimeException {

  OpenWeatherPersistenceException(String message, Throwable exception) {
    super(message, exception);
  }

}
