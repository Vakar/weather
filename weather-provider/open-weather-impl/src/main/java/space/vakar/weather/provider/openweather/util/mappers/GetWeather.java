package space.vakar.weather.provider.openweather.util.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.domain.model.weather.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.weather.atmosphere.CloudinessUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Clouds;
import space.vakar.weather.domain.model.weather.atmosphere.Humidity;
import space.vakar.weather.domain.model.weather.atmosphere.HumidityUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Precipitation;
import space.vakar.weather.domain.model.weather.atmosphere.PrecipitationUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Pressure;
import space.vakar.weather.domain.model.weather.atmosphere.PressureUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Visibility;
import space.vakar.weather.domain.model.weather.atmosphere.VisibilityUnit;
import space.vakar.weather.domain.model.weather.location.City;
import space.vakar.weather.domain.model.weather.location.Coordinates;
import space.vakar.weather.domain.model.weather.location.Location;
import space.vakar.weather.domain.model.weather.location.Sun;
import space.vakar.weather.domain.model.weather.temperature.Temperature;
import space.vakar.weather.domain.model.weather.temperature.TemperatureUnit;
import space.vakar.weather.domain.model.weather.wind.SpeedUnit;
import space.vakar.weather.domain.model.weather.wind.Wind;
import space.vakar.weather.domain.model.weather.wind.WindDirection;
import space.vakar.weather.domain.model.weather.wind.WindSpeed;
import space.vakar.weather.provider.openweather.model.CurrentWeather;

public class GetWeather {

  private GetWeather() {

  }

  /**
   * Convert {@link CurrentWeather} object to {@link Weather} object.
   *
   * @param current {@link CurrentWeather} object
   * @return {@link Weather} object
   */
  public static Weather from(CurrentWeather current) {
    Weather weather = new Weather();
    weather.setWind(getWind(current));
    weather.setAtmosphere(getAtmosphere(current));
    weather.setLocation(location(current));
    weather.setTemperature(getTemperature(current));
    weather.setMeasuringTime(current.getLastupdate().getValue());
    return weather;
  }

  private static Wind getWind(CurrentWeather currentWeather) {
    WindSpeed speed = getWindSpeed(currentWeather);
    WindDirection direction = getWindDirection(currentWeather);
    return new Wind(speed, direction);
  }

  private static WindSpeed getWindSpeed(CurrentWeather currentWeather) {
    BigDecimal value = currentWeather.getWind().getSpeed().getValue();
    String name = currentWeather.getWind().getSpeed().getName();
    return new WindSpeed(value, SpeedUnit.MILES_PER_HOUR, name);
  }

  private static WindDirection getWindDirection(

      CurrentWeather currentWeather) {
    BigDecimal value = currentWeather.getWind().getDirection().getValue();
    String code = currentWeather.getWind().getDirection().getCode();
    String name = currentWeather.getWind().getDirection().getName();
    return new WindDirection(value, code, name);
  }

  private static Atmosphere getAtmosphere(CurrentWeather currentWeather) {
    Humidity humidity = getHumidity(currentWeather);
    Pressure pressure = getPressure(currentWeather);
    Visibility visibility = new Visibility(getVisibility(currentWeather), VisibilityUnit.METER);
    Precipitation precipitation = getPrecipitation(currentWeather);
    Clouds clouds = getClouds(currentWeather);

    return new Atmosphere(humidity, pressure, visibility, precipitation, clouds);
  }

  private static Humidity getHumidity(CurrentWeather currentWeather) {
    BigDecimal value = currentWeather.getHumidity().getValue();
    return new Humidity(value, HumidityUnit.RELATIVE_HUMIDITY);
  }

  private static Pressure getPressure(CurrentWeather currentWeather) {
    BigDecimal value = currentWeather.getPressure().getValue();
    return new Pressure(value, PressureUnit.MILLIMETER_OF_MERCURY);
  }

  private static BigDecimal getVisibility(CurrentWeather currentWeather) {
    return currentWeather.getVisibility().getValue();
  }

  private static Precipitation getPrecipitation(CurrentWeather currentWeather) {
    BigDecimal value = currentWeather.getPrecipitation().getValue();
    String mode = currentWeather.getPrecipitation().getMode();
    return new Precipitation(value, PrecipitationUnit.MILLIMETRE, mode);
  }

  private static Clouds getClouds(CurrentWeather currentWeather) {
    BigDecimal value = currentWeather.getClouds().getValue();
    return new Clouds(value, CloudinessUnit.PERCENTAGE_OF_SKY_AREA);
  }

  private static Location location(CurrentWeather current) {
    Coordinates coordinates = getCoordinates(current);
    Sun sun = getSun(current);
    City city = getCity(current);
    String country = current.getCity().getCountry();
    return new Location(coordinates, sun, city, country);
  }

  private static Coordinates getCoordinates(CurrentWeather currentWeather) {
    BigDecimal longitude = currentWeather.getCity().getCoordinates().getLongitude();
    BigDecimal latitude = currentWeather.getCity().getCoordinates().getLatitude();
    return new Coordinates(longitude, latitude);
  }

  private static Sun getSun(CurrentWeather currentWeather) {
    LocalDateTime rise = currentWeather.getCity().getSun().getRise();
    LocalDateTime set = currentWeather.getCity().getSun().getSet();
    return new Sun(rise, set);
  }

  private static City getCity(CurrentWeather currentWeather) {
    int id = currentWeather.getCity().getId();
    String name = currentWeather.getCity().getName();
    return new City(id, name);
  }

  private static Temperature getTemperature(CurrentWeather currentWeather) {
    BigDecimal value = currentWeather.getTemperature().getValue();
    TemperatureUnit unit = currentWeather.getTemperature().getUnit();
    return new Temperature(value, unit);
  }
}
