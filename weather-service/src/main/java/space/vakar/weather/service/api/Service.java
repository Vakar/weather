package space.vakar.weather.service.api;

import space.vakar.weather.domain.model.Weather;

public interface Service {
	public Weather weather(int cityId);
}