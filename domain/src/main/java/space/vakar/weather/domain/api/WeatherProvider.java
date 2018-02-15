package space.vakar.weather.domain.api;

import space.vakar.weather.domain.model.Weather;

public interface WeatherProvider {
	
	public Weather provideWeather(int cityId) throws Exception;

}
