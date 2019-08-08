package space.vakar.weather.domain.core;

import space.vakar.weather.domain.model.WeatherDTO;

interface Agent {

	WeatherDTO weather(int cityId);

	boolean isFresh(WeatherDTO weather);
}
