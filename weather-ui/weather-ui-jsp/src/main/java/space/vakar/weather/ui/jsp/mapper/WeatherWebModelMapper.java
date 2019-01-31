package space.vakar.weather.ui.jsp.mapper;

import java.time.LocalDateTime;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.ui.jsp.model.WeatherWebModel;

public class WeatherWebModelMapper {

  public WeatherWebModel from(Weather w) {
    WeatherWebModel weather = new WeatherWebModel();
    weather.setCityName(w.getLocation().getCity().getName());
    weather.setCityLon(w.getLocation().getCoordinates().getLongitude().toPlainString());
    weather.setCityLat(w.getLocation().getCoordinates().getLatitude().toPlainString());
    weather.setCountry(w.getLocation().getCountry());
    weather.setSunRise(getTime(w.getLocation().getSun().getRise()));
    weather.setSunSet(getTime(w.getLocation().getSun().getSet()));
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
    weather.setCloudsName(w.getAtmosphere().getClouds().getCloudinessName());
    weather.setLastUpdate(w.getMeasuringTime().toString());
    return weather;
  }

  private String getTime(LocalDateTime localTime) {
    return localTime.getHour() + ":" + localTime.getMinute();
  }
}
