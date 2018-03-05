package space.vakar.weather.provider.openweather.impl;

import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.provider.openweather.api.Provider;
import space.vakar.weather.provider.openweather.exceptions.WeatherProviderException;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.util.mappers.GetWeather;

public class ProviderImpl implements Provider {

  private ParserImpl parser = new ParserImpl();

  @Override
  public Weather provideWeather(int city) throws WeatherProviderException {
    Weather weather = null;
    try {
      CurrentWeather currentWeather = parser.weather(city);
      weather = GetWeather.from(currentWeather);
    } catch (Exception ex) {
      throw new WeatherProviderException("Can't provide weather.", ex);
    }
    return weather;
  }
}
