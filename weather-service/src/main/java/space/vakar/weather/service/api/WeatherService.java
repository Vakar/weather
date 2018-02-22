package space.vakar.weather.service.api;

import space.vakar.weather.domain.model.Weather;

public interface WeatherService {
	public Weather weather(int cityId);
}