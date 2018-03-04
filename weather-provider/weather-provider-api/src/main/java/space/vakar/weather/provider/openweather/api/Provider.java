package space.vakar.weather.provider.openweather.api;

import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.provider.openweather.exceptions.OpenWeatherProviderException;

public interface Provider {

  public Weather provideWeather(int cityId) throws OpenWeatherProviderException;

}
