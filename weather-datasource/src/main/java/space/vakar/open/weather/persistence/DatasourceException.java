package space.vakar.open.weather.persistence;

class DatasourceException extends RuntimeException {

  DatasourceException(String message, Throwable exception) {
    super(message, exception);
  }

}
