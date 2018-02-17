package space.vakar.weather.provider.openweather.testutils;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import space.vakar.weather.domain.model.temperature.TemperatureUnit;
import space.vakar.weather.provider.openweather.model.City;
import space.vakar.weather.provider.openweather.model.Clouds;
import space.vakar.weather.provider.openweather.model.Coordinates;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.model.Gusts;
import space.vakar.weather.provider.openweather.model.Humidity;
import space.vakar.weather.provider.openweather.model.LastUpdate;
import space.vakar.weather.provider.openweather.model.Precipitation;
import space.vakar.weather.provider.openweather.model.Pressure;
import space.vakar.weather.provider.openweather.model.Sun;
import space.vakar.weather.provider.openweather.model.Temperature;
import space.vakar.weather.provider.openweather.model.Visibility;
import space.vakar.weather.provider.openweather.model.Weather;
import space.vakar.weather.provider.openweather.model.Wind;
import space.vakar.weather.provider.openweather.model.WindDirection;
import space.vakar.weather.provider.openweather.model.WindSpeed;

public class CurrentWeatherPopulator {

	public static void populateData(CurrentWeather weather) {
		weather.setCity(getCity());
		weather.setTemperature(new Temperature(new BigDecimal("261.15"), new BigDecimal("261.15"), new BigDecimal("261.15"), TemperatureUnit.KELVIN));
		weather.setHumidity(new Humidity(new BigDecimal("85"), "%"));
		weather.setPressure(new Pressure(new BigDecimal("1002"), "hPa"));
		weather.setWind(getWind());
		weather.setClouds(new Clouds(new BigDecimal("90"), "overcast clouds"));
		weather.setVisibility(new Visibility(new BigDecimal("4828")));
		weather.setPrecipitation(new Precipitation(new BigDecimal("13.4"), "snow"));
		weather.setWeather(new Weather(600, "light snow", "13n"));
		weather.setLastupdate(getLastUpdate());
	}

	private static  City getCity() {
		LocalDateTime rise = LocalDateTime.parse("2018-01-31T11:42:29");
		LocalDateTime set = LocalDateTime.parse("2018-01-31T21:23:30");
		Sun sun = new Sun(rise, set);
		Coordinates coordinates = new Coordinates(new BigDecimal("-64.8"), new BigDecimal("46.1"));
		return new City(6076211, "Moncton", "CA", sun, coordinates);
	}

	private static  Wind getWind() {
		WindSpeed speed = new WindSpeed(new BigDecimal("7.7"), "Moderate breeze");
		Gusts gusts = new Gusts(new BigDecimal("11.3"));
		WindDirection direction = new WindDirection(new BigDecimal("290"), "WNW", "West-northwest");		
		return new Wind(speed, gusts, direction);
	}

	private static LastUpdate getLastUpdate() {
		return new LastUpdate(LocalDateTime.parse("2018-01-31T08:27:00"));
	}
}
