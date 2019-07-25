package space.vakar.weather.domain.core;

import space.vakar.weather.domain.model.WeatherDTO;

public interface WeatherService {

	WeatherDTO weather(int cityId);
}
