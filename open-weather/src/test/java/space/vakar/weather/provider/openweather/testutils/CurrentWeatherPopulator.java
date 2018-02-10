package space.vakar.weather.provider.openweather.testutils;

import java.time.LocalDateTime;

import space.vakar.weather.domain.model.temperature.TemperatureUnit;
import space.vakar.weather.provider.openweather.model.City;
import space.vakar.weather.provider.openweather.model.Clouds;
import space.vakar.weather.provider.openweather.model.Coordinates;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
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

	public static void populate(CurrentWeather weather) {
		weather.setCity(getCity());
		weather.setTemperature(new Temperature(261.15, 261.15, 261.15, TemperatureUnit.KELVIN));
		weather.setHumidity(new Humidity(85, "%"));
		weather.setPressure(new Pressure(1002, "hPa"));
		weather.setWind(getWind());
		weather.setClouds(new Clouds(90, "overcast clouds"));
		weather.setVisibility(new Visibility(4828));
		weather.setPrecipitation(new Precipitation(13.4, "snow"));
		weather.setWeather(new Weather(600, "light snow", "13n"));
		weather.setLastupdate(getLastUpdate());
	}

	private static  City getCity() {
		LocalDateTime rise = LocalDateTime.parse("2018-01-31T11:42:29");
		LocalDateTime set = LocalDateTime.parse("2018-01-31T21:23:30");
		Sun sun = new Sun(rise, set);
		Coordinates coordinates = new Coordinates(-64.8, 46.1);
		return new City(6076211, "Moncton", "CA", sun, coordinates);
	}

	private static  Wind getWind() {
		WindSpeed speed = new WindSpeed(7.7, "Moderate breeze");
		WindDirection direction = new WindDirection(290, "WNW", "West-northwest");
		return new Wind(speed, direction);
	}

	private static LastUpdate getLastUpdate() {
		return new LastUpdate(LocalDateTime.parse("2018-01-31T08:27:00"));
	}
}
