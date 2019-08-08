package org.open.weather.persistence;

class OpenWeatherPersistenceException extends RuntimeException {

	OpenWeatherPersistenceException(String message) {
		super(message);
	}

	OpenWeatherPersistenceException(String message, Throwable exception) {
		super(message, exception);
	}

}
