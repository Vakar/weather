package space.vakar.weather.domain.api;

import space.vakar.weather.domain.Weather;

public interface WeatherRetriever {
	public Weather retrieveCurrantWeather(String cityId);
}
