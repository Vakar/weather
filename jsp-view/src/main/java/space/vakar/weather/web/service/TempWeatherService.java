package space.vakar.weather.web.service;

import space.vakar.weather.web.model.WeatherWebModel;

public class TempWeatherService {
  
  public WeatherWebModel weather() {
    WeatherWebModel weather = new WeatherWebModel();
    weather.setCityName("Moncton");
    weather.setCityLon("-64.8");
    weather.setCityLat("46.1");
    weather.setTemperatureValue("261.15");
    weather.setTemperatureUnit("kelvin");
    weather.setHumidityValue("85");
    weather.setHumidityUnit("%");
    return weather;
  }

}
