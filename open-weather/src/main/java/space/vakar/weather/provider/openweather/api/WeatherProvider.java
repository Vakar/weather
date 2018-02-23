package space.vakar.weather.provider.openweather.api;

import space.vakar.weather.domain.model.impl.Weather;

public interface WeatherProvider {
	
	public Weather provideWeather(int cityId) throws Exception;

}
