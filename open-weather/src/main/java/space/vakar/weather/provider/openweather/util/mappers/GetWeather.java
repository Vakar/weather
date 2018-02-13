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

	public static Weather from(CurrentWeather currentWeather) {
		if (currentWeather == null)
			return null;
		Weather weather = new Weather();
		weather.setWind(getWind(currentWeather));
		weather.setAtmosphere(getAtmosphere(currentWeather));
		weather.setLocation(getLocation(currentWeather));
		weather.setTemperature(getTemperature(currentWeather));
		weather.setLastUpdate(currentWeather.getLastupdate().getValue());
		return weather;
	}

	private static Wind getWind(CurrentWeather currentWeather) {
		if(currentWeather.getWind() == null)
			return new Wind().defaultInstance();
		WindSpeed speed = getWindSpeed(currentWeather);
		WindDirection direction = getWindDirection(currentWeather);
		return new Wind(speed, direction);
	}

	private static WindSpeed getWindSpeed(CurrentWeather currentWeather) {
		if(currentWeather.getWind().getSpeed() == null)
			return new WindSpeed().defaultInstance();
		double value = currentWeather.getWind().getSpeed().getValue();
		String name = currentWeather.getWind().getSpeed().getName();
		return new WindSpeed(value, name);
	}

	private static WindDirection getWindDirection(
			CurrentWeather currentWeather) {
		if(currentWeather.getWind().getDirection() == null)
			return new WindDirection().defaultInstance();
		double value = currentWeather.getWind().getDirection().getValue();
		String code = currentWeather.getWind().getDirection().getCode();
		String name = currentWeather.getWind().getDirection().getName();
		return new WindDirection(value, code, name);
	}

	private static Atmosphere getAtmosphere(CurrentWeather currentWeather) {
		Humidity humidity = getHumidity(currentWeather);
		Pressure pressure = getPressure(currentWeather);
		double visibility = getVisibility(currentWeather);
		Precipitation precipitation = getPrecipitation(currentWeather);
		Clouds clouds = getClouds(currentWeather);
		return new Atmosphere(humidity, pressure, visibility, precipitation,
				clouds);
	}

	private static Humidity getHumidity(CurrentWeather currentWeather) {
		if(currentWeather.getHumidity() == null)
			return new Humidity().defaultInstance();
		double value = currentWeather.getHumidity().getValue();
		String unit = currentWeather.getHumidity().getUnit();
		return new Humidity(value, unit);
	}

	private static Pressure getPressure(CurrentWeather currentWeather) {
		if(currentWeather.getPressure() == null)
			return new Pressure().defaultInstance();
		double value = currentWeather.getPressure().getValue();
		String unit = currentWeather.getPressure().getUnit();
		return new Pressure(value, unit);
	}
	
	private static double getVisibility(CurrentWeather currentWeather) {
		if(currentWeather.getVisibility() == null)
			return Double.NaN;
		return currentWeather.getVisibility().getValue();
	}

	private static Precipitation getPrecipitation(
			CurrentWeather currentWeather) {
		if(currentWeather.getPrecipitation() == null)
			return new Precipitation().defaultInstance();
		double value = currentWeather.getPrecipitation().getValue();
		String mode = currentWeather.getPrecipitation().getMode();
		return new Precipitation(value, mode);
	}

	private static Clouds getClouds(CurrentWeather currentWeather) {
		if(currentWeather.getClouds() == null)
			return new Clouds().defaultInstance();
		double value = currentWeather.getClouds().getValue();
		String name = currentWeather.getClouds().getName();
		return new Clouds(value, name);
	}

	private static Location getLocation(CurrentWeather currentWeather) {
		Coordinates coordinates = getCoordinates(currentWeather);
		Sun sun = getSun(currentWeather);
		City city = getCity(currentWeather);
		String country = currentWeather.getCity().getCountry();
		return new Location(coordinates, sun, city, country);
	}

	private static Coordinates getCoordinates(CurrentWeather currentWeather) {
		if(currentWeather.getCity() == null) {
			return new Coordinates().defaultInstance();
		} else if (currentWeather.getCity().getCoordinates() == null) {
			return new Coordinates().defaultInstance();
		}	
		double longitude = currentWeather.getCity().getCoordinates()
				.getLongitude();
		;
		double latitude = currentWeather.getCity().getCoordinates()
				.getLatitude();
		return new Coordinates(longitude, latitude);
	}

	private static Sun getSun(CurrentWeather currentWeather) {
		if(currentWeather.getCity() == null) {
			return new Sun().defaultInstance();
		} else if (currentWeather.getCity().getSun() == null) {
			return new Sun().defaultInstance();
		}			
		LocalDateTime rise = currentWeather.getCity().getSun().getRise();
		LocalDateTime set = currentWeather.getCity().getSun().getSet();
		return new Sun(rise, set);
	}

	private static City getCity(CurrentWeather currentWeather) {
		if(currentWeather.getCity() == null)
			return new City().defaultInstance();
		int id = currentWeather.getCity().getId();
		String name = currentWeather.getCity().getName();
		return new City(id, name);
	}

	private static Temperature getTemperature(CurrentWeather currentWeather) {
		if(currentWeather.getTemperature() == null)
			return new Temperature().defaultInstance();
		double value = currentWeather.getTemperature().getValue();
		TemperatureUnit unit = currentWeather.getTemperature().getUnit();
		return new Temperature(value, unit);
	}
}
