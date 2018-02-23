package space.vakar.weather.provider.openweather.util.mappers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.domain.model.impl.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.impl.atmosphere.Clouds;
import space.vakar.weather.domain.model.impl.atmosphere.Humidity;
import space.vakar.weather.domain.model.impl.atmosphere.Precipitation;
import space.vakar.weather.domain.model.impl.atmosphere.Pressure;
import space.vakar.weather.domain.model.impl.location.City;
import space.vakar.weather.domain.model.impl.location.Coordinates;
import space.vakar.weather.domain.model.impl.location.Location;
import space.vakar.weather.domain.model.impl.location.Sun;
import space.vakar.weather.domain.model.impl.temperature.Temperature;
import space.vakar.weather.domain.model.impl.temperature.TemperatureUnit;
import space.vakar.weather.domain.model.impl.wind.Wind;
import space.vakar.weather.domain.model.impl.wind.WindDirection;
import space.vakar.weather.domain.model.impl.wind.WindSpeed;
import space.vakar.weather.provider.openweather.model.CurrentWeather;

public class GetWeather {

	public static Weather from(CurrentWeather current) {

		Weather weather = new Weather();
		weather.setWind(getWind(current));
		weather.setAtmosphere(getAtmosphere(current));
		weather.setLocation(location(current));
		weather.setTemperature(getTemperature(current));
		weather.setLastUpdate(current.getLastupdate().getValue());
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

		return new WindSpeed(value, name);
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
		BigDecimal visibility = getVisibility(currentWeather);
		Precipitation precipitation = getPrecipitation(currentWeather);
		Clouds clouds = getClouds(currentWeather);

		return new Atmosphere(humidity, pressure, visibility, precipitation,
				clouds);
	}

	private static Humidity getHumidity(CurrentWeather currentWeather) {
		BigDecimal value = currentWeather.getHumidity().getValue();
		String unit = currentWeather.getHumidity().getUnit();
		return new Humidity(value, unit);
	}

	private static Pressure getPressure(CurrentWeather currentWeather) {
		BigDecimal value = currentWeather.getPressure().getValue();
		String unit = currentWeather.getPressure().getUnit();
		return new Pressure(value, unit);
	}
	
	private static BigDecimal getVisibility(CurrentWeather currentWeather) {
		return currentWeather.getVisibility().getValue();
	}

	private static Precipitation getPrecipitation(
			CurrentWeather currentWeather) {
		BigDecimal value = currentWeather.getPrecipitation().getValue();
		String mode = currentWeather.getPrecipitation().getMode();
		return new Precipitation(value, mode);
	}

	private static Clouds getClouds(CurrentWeather currentWeather) {
		BigDecimal value = currentWeather.getClouds().getValue();
		String name = currentWeather.getClouds().getName();

		return new Clouds(value, name);
	}

	private static Location location(CurrentWeather current) {
		Coordinates coordinates = getCoordinates(current);
		Sun sun = getSun(current);
		City city = getCity(current);
		String country = current.getCity().getCountry();
		return new Location(coordinates, sun, city, country);
	}

	private static Coordinates getCoordinates(CurrentWeather currentWeather) {
		BigDecimal longitude = currentWeather.getCity().getCoordinates()
				.getLongitude();
		;
		BigDecimal latitude = currentWeather.getCity().getCoordinates()
				.getLatitude();
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
