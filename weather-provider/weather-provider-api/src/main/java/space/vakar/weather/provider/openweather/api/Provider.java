package space.vakar.weather.provider.openweather.api;

import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.provider.openweather.exceptions.WeatherProviderException;

public interface Provider {

  Weather provideWeather(int cityId) throws WeatherProviderException;
}
