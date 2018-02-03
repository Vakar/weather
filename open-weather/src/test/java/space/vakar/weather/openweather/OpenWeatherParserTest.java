package space.vakar.weather.openweather;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDateTime;

import org.junit.Test;

import space.vakar.weather.domain.Atmosphere;
import space.vakar.weather.domain.City;
import space.vakar.weather.domain.Coordinates;
import space.vakar.weather.domain.Humidity;
import space.vakar.weather.domain.Pressure;
import space.vakar.weather.domain.Temperature;
import space.vakar.weather.domain.TemperatureUnit;
import space.vakar.weather.domain.Weather;
import space.vakar.weather.domain.Wind;
import space.vakar.weather.domain.WindDirection;
import space.vakar.weather.domain.WindSpeed;

public class OpenWeatherParserTest {
	
	private OpenWeatherParser weatherParser = new OpenWeatherParser();
	
	@Test
	public void shouldReturnCorrectObject() throws IOException {
		ClassLoader loader = getClass().getClassLoader();
		InputStream inputStream = loader.getResource("weather.xml").openStream();
		assertEquals(getExpectedWeather(), weatherParser.parse(inputStream));		
	}
	
	private Weather getExpectedWeather() {
		WindSpeed windSpeed = new WindSpeed(7.7, "Moderate breeze");
		WindDirection windDirection = new WindDirection(290, "WNW", "West-northwest");
		Wind wind = new Wind(windSpeed, windDirection);
		Humidity humidity = new Humidity(85, "%");
		Pressure pressure = new Pressure(1002, "hPa");
		Atmosphere atmosphere = new Atmosphere(humidity, pressure, 4828, 0);
		Coordinates coordinates = new Coordinates(-64.8, 46.1);
		City city = new City("Moncton", "CA", coordinates);
		Temperature temperature = new Temperature(261.15, TemperatureUnit.KELVIN);
		LocalDateTime lastUpdate = LocalDateTime.parse("2018-01-31T08:27:00");
		return new Weather(wind, atmosphere, city, temperature, lastUpdate);
	}
}
