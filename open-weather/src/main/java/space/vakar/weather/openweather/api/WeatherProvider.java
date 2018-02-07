package space.vakar.weather.openweather.api;

import space.vakar.weather.domain.model.Weather;

public interface WeatherProvider {
	
	public Weather provideWeather();

}
