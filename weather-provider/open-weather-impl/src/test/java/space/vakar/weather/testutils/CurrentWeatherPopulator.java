package space.vakar.weather.testutils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import space.vakar.weather.domain.model.weather.temperature.TemperatureUnit;
import space.vakar.weather.model.City;
import space.vakar.weather.model.Clouds;
import space.vakar.weather.model.Coordinates;
import space.vakar.weather.model.CurrentWeather;
import space.vakar.weather.model.Gusts;
import space.vakar.weather.model.Humidity;
import space.vakar.weather.model.LastUpdate;
import space.vakar.weather.model.Precipitation;
import space.vakar.weather.model.Pressure;
import space.vakar.weather.model.Sun;
import space.vakar.weather.model.Temperature;
import space.vakar.weather.model.Visibility;
import space.vakar.weather.model.Weather;
import space.vakar.weather.model.Wind;
import space.vakar.weather.model.WindDirection;
import space.vakar.weather.model.WindSpeed;

public class CurrentWeatherPopulator {

  /**
   * Set hard code data for {@link CurrentWeather} objects.
   *
   * @param weather input {@link CurrentWeather} object
   */
  public static void populateData(CurrentWeather weather) {
    weather.setCity(getCity());
    weather.setTemperature(new Temperature(new BigDecimal("261.15"), new BigDecimal("261.15"),
        new BigDecimal("261.15"), TemperatureUnit.KELVIN));
    weather.setHumidity(new Humidity(new BigDecimal("85"), "%"));
    weather.setPressure(new Pressure(new BigDecimal("1002"), "hPa"));
    weather.setWind(getWind());
    weather.setClouds(new Clouds(new BigDecimal("90"), "overcast clouds"));
    weather.setVisibility(new Visibility(new BigDecimal("4828")));
    weather.setPrecipitation(new Precipitation(new BigDecimal("13.4"), "snow"));
    weather.setWeather(new Weather(600, "light snow", "13n"));
    weather.setLastupdate(getLastUpdate());
  }

  private static City getCity() {
    LocalDateTime rise = LocalDateTime.parse("2018-01-31T11:42:29");
    LocalDateTime set = LocalDateTime.parse("2018-01-31T21:23:30");
    Sun sun = new Sun(rise, set);
    Coordinates coordinates = new Coordinates(new BigDecimal("-64.8"), new BigDecimal("46.1"));
    return new City(6076211, "Moncton", "CA", sun, coordinates);
  }

  private static Wind getWind() {
    WindSpeed speed = new WindSpeed(new BigDecimal("7.7"), "Moderate breeze");
    Gusts gusts = new Gusts(new BigDecimal("11.3"));
    WindDirection direction = new WindDirection(new BigDecimal("290"), "WNW", "West-northwest");
    return new Wind(speed, gusts, direction);
  }

  private static LastUpdate getLastUpdate() {
    return new LastUpdate(LocalDateTime.parse("2018-01-31T08:27:00"));
  }
}
