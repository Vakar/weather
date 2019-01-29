package space.vakar.weather.domain.api;

import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.domain.exceptions.WeatherProviderException;

public interface Provider {

  Weather provideWeather(int cityId) throws WeatherProviderException;
}
