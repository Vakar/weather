package space.vakar.weather.domain.api;

import space.vakar.weather.domain.model.WeatherDTO;

public interface Provider {

	WeatherDTO provideWeather(int cityId);
}
