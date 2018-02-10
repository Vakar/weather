package space.vakar.weather.provider.openweather.testutils;

import java.time.LocalDateTime;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.domain.model.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.atmosphere.Clouds;
import space.vakar.weather.domain.model.atmosphere.Humidity;
import space.vakar.weather.domain.model.atmosphere.Precipitation;
import space.vakar.weather.domain.model.atmosphere.Pressure;
import space.vakar.weather.domain.model.location.City;
import space.vakar.weather.domain.model.location.Coordinates;
import space.vakar.weather.domain.model.location.Location;
import space.vakar.weather.domain.model.location.Sun;
import space.vakar.weather.domain.model.temperature.Temperature;
import space.vakar.weather.domain.model.temperature.TemperatureUnit;
import space.vakar.weather.domain.model.wind.Wind;
import space.vakar.weather.domain.model.wind.WindDirection;
import space.vakar.weather.domain.model.wind.WindSpeed;


public class WeatherPopulator {
	
	public static Weather populate(Weather weather) {
	      weather.setWind(getWind());
	      weather.setAtmosphere(getAtmosphere());
	      weather.setLocation(getLocation());
	      weather.setTemperature(getTemperature());
	      weather.setLastUpdate(LocalDateTime.parse("2018-01-31T08:27:00"));
	      return weather;
	}
	
	private static Wind getWind() {
		WindSpeed speed = new WindSpeed(7.7, "Moderate breeze");
		WindDirection direction = new WindDirection(290, "WNW", "West-northwest");
		return new Wind(speed, direction);
	}
	
	private static Atmosphere getAtmosphere() {
		Humidity humidity = new Humidity(85, "%");
		Pressure pressure = new Pressure(1002, "hPa");
		double visibility = 4828;
		Precipitation precipitation = new Precipitation(13.4, "snow");
		Clouds clouds = new Clouds(90, "overcast clouds");
		return new Atmosphere(humidity, pressure, visibility, precipitation, clouds);
	}
	
	private static Location getLocation() {
		Coordinates coordinates = new Coordinates(-64.8, 46.1);
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
		double value = 261.15;
		TemperatureUnit unit = TemperatureUnit.KELVIN;
		return new Temperature(value, unit);
	}
}
