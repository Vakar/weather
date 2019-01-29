package space.vakar.open.weather.impl;

import space.vakar.weather.domain.api.Provider;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.domain.exceptions.WeatherProviderException;
import space.vakar.open.weather.model.CurrentWeather;
import space.vakar.open.weather.util.mappers.GetWeather;

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
