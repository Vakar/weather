package space.vakar.weather.api;

import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.exceptions.WeatherProviderException;

public interface Provider {

  Weather provideWeather(int cityId) throws WeatherProviderException;
}
