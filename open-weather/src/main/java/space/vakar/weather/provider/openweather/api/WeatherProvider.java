package space.vakar.weather.provider.openweather.api;

import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.provider.openweather.exceptions.OpenWeatherProviderException;

public interface WeatherProvider {

  public Weather provideWeather(int cityId) throws OpenWeatherProviderException;

}
