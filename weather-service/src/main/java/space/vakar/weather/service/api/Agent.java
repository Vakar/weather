package space.vakar.weather.service.api;

import space.vakar.weather.domain.model.Weather;

public interface Agent {
	public Weather weather(int cityId);

}