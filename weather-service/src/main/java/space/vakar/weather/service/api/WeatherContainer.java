package space.vakar.weather.service.api;

import space.vakar.weather.domain.model.Weather;

public interface WeatherContainer {
	public void update(Weather weather);
	public Weather weather(String cityName);
	public boolean isExist(String citName);
	public void put(Weather weather);
}