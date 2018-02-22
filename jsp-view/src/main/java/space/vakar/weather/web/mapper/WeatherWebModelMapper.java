package space.vakar.weather.web.mapper;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.web.model.WeatherWebModel;

public class WeatherWebModelMapper {
  
  public WeatherWebModel from(Weather w) {
    WeatherWebModel weather = new WeatherWebModel();
    weather.setCityName(w.getLocation().getCity().getName());
    weather.setCityLon(w.getLocation().getCoordinates().getLongitude().toPlainString());
    weather.setCityLat(w.getLocation().getCoordinates().getLatitude().toPlainString());
    weather.setTemperatureValue(w.getTemperature().getValue().toPlainString());
    weather.setTemperatureUnit(w.getTemperature().getUnit().name());
    weather.setHumidityValue(w.getAtmosphere().getHumidity().getValue().toPlainString());
    weather.setHumidityUnit(w.getAtmosphere().getHumidity().getUnit());
    return weather;
  }

}
