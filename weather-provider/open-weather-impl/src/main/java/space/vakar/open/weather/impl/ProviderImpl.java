package space.vakar.open.weather.impl;

import space.vakar.open.weather.api.Provider;
import space.vakar.open.weather.model.CurrentWeather;
import space.vakar.open.weather.impl.util.mappers.GetWeather;
import space.vakar.weather.domain.model.weather.Weather;

public class ProviderImpl implements Provider {

  private ParserImpl parser = new ParserImpl();

  @Override
  public Weather provideWeather(int city) {
    if (city < 0) return null;
    Weather weather;
    try {
      CurrentWeather currentWeather = parser.weather(city);
      weather = GetWeather.from(currentWeather);
    } catch (Exception ex) {
      throw new OpenWeatherException("Can't provide weather.", ex);
    }
    return weather;
  }
}
