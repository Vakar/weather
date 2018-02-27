package space.vakar.weather.provider.openweather.impl;

import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.provider.openweather.api.Provider;
import space.vakar.weather.provider.openweather.exceptions.OpenWeatherProviderException;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.util.mappers.GetWeather;

public class ProviderImpl implements Provider {

  private ParserImpl parser = new ParserImpl();

  @Override
  public Weather provideWeather(int city) throws OpenWeatherProviderException {
    Weather weather = null;
    try {
      CurrentWeather currentWeather = parser.weather(city);
      weather = GetWeather.from(currentWeather);
    } catch (Exception e) {
      throw new OpenWeatherProviderException("Can't provide weather.", e);
    }
    return weather;
  }
}
