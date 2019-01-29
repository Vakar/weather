package space.vakar.open.weather.testutils;

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


public class WeatherPopulator {

  /**
   *
   * @param weather
   * @return
   */
  public static Weather populate(Weather weather) {
    weather.setWind(getWind());
    weather.setAtmosphere(getAtmosphere());
    weather.setLocation(getLocation());
    weather.setTemperature(getTemperature());
    weather.setMeasuringTime(LocalDateTime.parse("2018-01-31T08:27:00"));
    return weather;
  }

  private static Wind getWind() {
    WindSpeed speed =
        new WindSpeed(new BigDecimal("7.7"), SpeedUnit.MILES_PER_HOUR, "Moderate breeze");
    WindDirection direction = new WindDirection(new BigDecimal("290"), "WNW", "West-northwest");
    return new Wind(speed, direction);
  }

  private static Atmosphere getAtmosphere() {
    Humidity humidity = new Humidity(new BigDecimal("85"), HumidityUnit.RELATIVE_HUMIDITY);
    Pressure pressure = new Pressure(new BigDecimal("1002"), PressureUnit.MILLIMETER_OF_MERCURY);
    Precipitation precipitation =
        new Precipitation(new BigDecimal("13.4"), PrecipitationUnit.MILLIMETRE, "snow");
    Clouds clouds =
        new Clouds(new BigDecimal("90"), CloudinessUnit.PERCENTAGE_OF_SKY_AREA, "overcast clouds");
    Visibility visibility = new Visibility(new BigDecimal("4828"), VisibilityUnit.METER);
    return new Atmosphere(humidity, pressure, visibility, precipitation, clouds);
  }

  private static Location getLocation() {
    Coordinates coordinates = new Coordinates(new BigDecimal("-64.8"), new BigDecimal("46.1"));
    Sun sun = getSun();
    City city = new City(6076211, "Moncton");
    String country = "CA";
    return new Location(coordinates, sun, city, country);
  }

  private static Sun getSun() {
    LocalDateTime rise = LocalDateTime.parse("2018-01-31T11:42:29");
    LocalDateTime set = LocalDateTime.parse("2018-01-31T21:23:30");
    return new Sun(rise, set);
  }

  private static Temperature getTemperature() {
    BigDecimal value = new BigDecimal("261.15");
    TemperatureUnit unit = TemperatureUnit.KELVIN;
    return new Temperature(value, unit);
  }
}
