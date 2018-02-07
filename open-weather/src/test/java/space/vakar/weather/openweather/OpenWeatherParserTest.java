package space.vakar.weather.openweather;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.time.LocalDateTime;

import org.junit.Test;

import space.vakar.weather.domain.model.temperature.TemperatureUnit;
import space.vakar.weather.openweather.model.City;
import space.vakar.weather.openweather.model.Clouds;
import space.vakar.weather.openweather.model.Coordinates;
import space.vakar.weather.openweather.model.CurrentWeather;
import space.vakar.weather.openweather.model.Humidity;
import space.vakar.weather.openweather.model.LastUpdate;
import space.vakar.weather.openweather.model.Precipitation;
import space.vakar.weather.openweather.model.Pressure;
import space.vakar.weather.openweather.model.Sun;
import space.vakar.weather.openweather.model.Temperature;
import space.vakar.weather.openweather.model.Visibility;
import space.vakar.weather.openweather.model.Weather;
import space.vakar.weather.openweather.model.Wind;
import space.vakar.weather.openweather.model.WindDirection;
import space.vakar.weather.openweather.model.WindSpeed;
import utils.CurrentWeatherBuilder;

public class OpenWeatherParserTest {
	
	private OpenWeatherParser weatherParser = new OpenWeatherParser();
	
	@Test
	public void shouldReturnCorrectObject() throws Exception {
		ClassLoader loader = getClass().getClassLoader();
		InputStream inputStream = loader.getResource("weather.xml").openStream();
		assertEquals(getExpectedWeather(), weatherParser.parse(inputStream));		
	}
	
	private CurrentWeather getExpectedWeather() {
		CurrentWeatherBuilder cwb = new CurrentWeatherBuilder();		
		cwb.city(getCity());
		cwb.temperature(new Temperature(261.15, 261.15, 261.15, TemperatureUnit.KELVIN));
		cwb.humidity(new Humidity(85, "%"));
		cwb.pressure(new Pressure(1002, "hPa"));		
		cwb.wind(getWind());
		cwb.clouds(new Clouds(90, "overcast clouds"));
		cwb.visibility(new Visibility(4828));
		cwb.precipitation(new Precipitation(13.4, "snow"));
		cwb.weather(new Weather(600, "light snow", "13n"));
		cwb.lastupdate(new LastUpdate(LocalDateTime.parse("2018-01-31T08:27:00")));
		return cwb.build();
	}
	
	private City getCity() {
		LocalDateTime rise = LocalDateTime.parse("2018-01-31T11:42:29");
		LocalDateTime set = LocalDateTime.parse("2018-01-31T21:23:30");
		Sun sun = new Sun(rise, set);
		Coordinates coordinates = new Coordinates(-64.8, 46.1);
		return new City(6076211, "Moncton", "CA", sun, coordinates);
	}
	
	private Wind getWind() {
		WindSpeed speed = new WindSpeed(7.7, "Moderate breeze");
		WindDirection direction = new WindDirection(290, "WNW", "West-northwest");
		return new Wind(speed, direction);
	}
}
