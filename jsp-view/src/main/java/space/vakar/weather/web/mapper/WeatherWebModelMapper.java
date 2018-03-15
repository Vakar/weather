package space.vakar.weather.web.mapper;

import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.web.model.WeatherWebModel;

public class WeatherWebModelMapper {
  
  public WeatherWebModel from(Weather w) {
    WeatherWebModel weather = new WeatherWebModel();
    weather.setCityName(w.getLocation().getCity().getName());
    weather.setCityLon(w.getLocation().getCoordinates().getLongitude().toPlainString());
    weather.setCityLat(w.getLocation().getCoordinates().getLatitude().toPlainString());
    weather.setCountry(w.getLocation().getCountry());
    weather.setSunRise(w.getLocation().getSun().getRise().toString());
    weather.setSunSet(w.getLocation().getSun().getSet().toString());
    weather.setTemperatureValue(w.getTemperature().getValue().toPlainString());
    weather.setTemperatureUnit(w.getTemperature().getUnit().getShortName());
    weather.setHumidityValue(w.getAtmosphere().getHumidity().getValue().toPlainString());
    weather.setHumidityUnit(w.getAtmosphere().getHumidity().getUnit().getShortName());
    weather.setPressureValue(w.getAtmosphere().getPressure().getValue().toPlainString());
    weather.setPressureUnit(w.getAtmosphere().getPressure().getUnit().getShortName());
    weather.setWindSpeed(w.getWind().getSpeed().getValue().toPlainString());
    weather.setWindName(w.getWind().getSpeed().getName());
    weather.setWindDirection(w.getWind().getDirection().getName());
    weather.setCloudsValue(w.getAtmosphere().getClouds().getValue().toPlainString());
    weather.setCloudsName(w.getAtmosphere().getClouds().getUnit().getShortName());
    weather.setLastUpdate(w.getMeasuringTime().toString());
    return weather;
  }

}
