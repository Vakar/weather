package space.vakar.weather.service.api;

import space.vakar.weather.domain.model.Weather;

public interface WeatherContainer {	
	public void push(Weather weather);
	public Weather pull(int cityId);
	public boolean isExist(int cityId);
	public boolean isFresh(int cityId);
}