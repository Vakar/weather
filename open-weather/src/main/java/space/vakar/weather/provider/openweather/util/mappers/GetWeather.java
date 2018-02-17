package space.vakar.weather.provider.openweather.util.mappers;

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
import space.vakar.weather.provider.openweather.model.CurrentWeather;

public class GetWeather {

	public static Weather from(CurrentWeather current) {
		if (current == null)
			return null;
		Weather weather = new Weather();
		weather.setWind(getWind(current));
		weather.setAtmosphere(getAtmosphere(current));
		weather.setLocation(location(current));
		weather.setTemperature(temperature(current));
		weather.setLastUpdate(current.getLastupdate().getValue());
		return weather;
	}

	private static Wind getWind(CurrentWeather current) {
		WindSpeed speed = getWindSpeed(current);
		WindDirection direction = getWindDirection(current);
		return new Wind(speed, direction);
	}

	private static WindSpeed getWindSpeed(CurrentWeather current) {
		double value = current.getWind().getSpeed().getValue();
		String name = current.getWind().getSpeed().getName();
		return new WindSpeed(value, name);
	}

	private static WindDirection getWindDirection(
			CurrentWeather current) {
		double value = current.getWind().getDirection().getValue();
		String code = current.getWind().getDirection().getCode();
		String name = current.getWind().getDirection().getName();
		return new WindDirection(value, code, name);
	}

	private static Atmosphere getAtmosphere(CurrentWeather current) {
		Humidity humidity = getHumidity(current);
		Pressure pressure = getPressure(current);
		double visibility = visibility(current);
		Precipitation precipitation = precipitation(current);
		Clouds clouds = clouds(current);
		return new Atmosphere(humidity, pressure, visibility, precipitation,
				clouds);
	}

	private static Humidity getHumidity(CurrentWeather current) {
		double value = current.getHumidity().getValue();
		String unit = current.getHumidity().getUnit();
		return new Humidity(value, unit);
	}

	private static Pressure getPressure(CurrentWeather current) {
		double value = current.getPressure().getValue();
		String unit = current.getPressure().getUnit();
		return new Pressure(value, unit);
	}

	private static double visibility(CurrentWeather current) {
		return current.getVisibility().getValue();
	}

	private static Precipitation precipitation(CurrentWeather current) {
		double value = current.getPrecipitation().getValue();
		String mode = current.getPrecipitation().getMode();
		return new Precipitation(value, mode);
	}

	private static Clouds clouds(CurrentWeather current) {
		double value = current.getClouds().getValue();
		String name = current.getClouds().getName();
		return new Clouds(value, name);
	}

	private static Location location(CurrentWeather current) {
		Coordinates coordinates = coordinates(current);
		Sun sun = sun(current);
		City city = city(current);
		String country = current.getCity().getCountry();
		return new Location(coordinates, sun, city, country);
	}

	private static Coordinates coordinates(CurrentWeather current) {
		double longitude = current.getCity()
				.getCoordinates().getLongitude();
		double latitude = current.getCity()
				.getCoordinates().getLatitude();
		return new Coordinates(longitude, latitude);
	}

	private static Sun sun(CurrentWeather current) {
		LocalDateTime rise = current.getCity().getSun().getRise();
		LocalDateTime set = current.getCity().getSun().getSet();
		return new Sun(rise, set);
	}

	private static City city(CurrentWeather current) {
		int id = current.getCity().getId();
		String name = current.getCity().getName();
		return new City(id, name);
	}

	private static Temperature temperature(CurrentWeather current) {
		double value = current.getTemperature().getValue();
		TemperatureUnit unit = current.getTemperature().getUnit();
		return new Temperature(value, unit);
	}
}
