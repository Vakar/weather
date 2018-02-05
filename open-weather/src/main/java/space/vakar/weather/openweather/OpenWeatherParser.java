package space.vakar.weather.openweather;

import java.io.InputStream;
import java.time.LocalDateTime;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import space.vakar.weather.domain.Atmosphere;
import space.vakar.weather.domain.City;
import space.vakar.weather.domain.Coordinates;
import space.vakar.weather.domain.Humidity;
import space.vakar.weather.domain.Precipitation;
import space.vakar.weather.domain.Pressure;
import space.vakar.weather.domain.Temperature;
import space.vakar.weather.domain.TemperatureUnit;
import space.vakar.weather.domain.Weather;
import space.vakar.weather.domain.Wind;
import space.vakar.weather.domain.WindDirection;
import space.vakar.weather.domain.WindSpeed;
import space.vakar.weather.domain.api.AbstractWeatherParser;
import utils.UnitInterpriter;

public class OpenWeatherParser extends AbstractWeatherParser{

	@Override
	public Weather parse(InputStream inputStream) throws DocumentException {
		SAXReader xmlReader = new SAXReader();
		Document doc = xmlReader.read(inputStream);
		WindSpeed windSpeed = parseWindSpeed(doc);
		WindDirection windDirection = parseWindDirection(doc);
		Wind wind = new Wind(windSpeed, windDirection);	
		Humidity humidity = parseHumidity(doc);
		Pressure pressure = parsePressure(doc);
		String value = doc.valueOf( "//current/visibility/@value" );
		Precipitation precipitation = parsePrecipitation(doc);
		Atmosphere atmosphere = new Atmosphere(humidity, pressure, Integer.valueOf(value), precipitation);	
		String cityName = doc.valueOf( "//current/city/@name" ); 
		String country = doc.valueOf( "//current/city/country" );
		Coordinates coordinates = parseCoordinates(doc);
		City city = new City(cityName, country, coordinates);		
		String temperatureValue = doc.valueOf( "//current/temperature/@value" );
		TemperatureUnit temUnit = parseTemperatureUnit(doc);
		Temperature temperature = new Temperature(Double.parseDouble(temperatureValue), temUnit);	
		String lastUpdateValue = doc.valueOf( "//current/lastupdate/@value" );
		LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdateValue);
		return new Weather(wind, atmosphere, city, temperature, lastUpdate);
	}
	
	private WindSpeed parseWindSpeed(Document doc) {
		String value = doc.valueOf( "//current/wind/speed/@value" );
		String name = doc.valueOf( "//current/wind/speed/@name" );
		return new WindSpeed(Double.parseDouble(value), name);
	}
	
	private WindDirection parseWindDirection(Document doc) {
		String value = doc.valueOf( "//current/wind/direction/@value" );
		String code = doc.valueOf( "//current/wind/direction/@code" );
		String name = doc.valueOf( "//current/wind/direction/@name" );
		return new WindDirection(Double.parseDouble(value), code, name);
	}
	
	private Humidity parseHumidity(Document doc) {
		String value = doc.valueOf( "//current/humidity/@value" );
		String unit = doc.valueOf( "//current/humidity/@unit" );
		return new Humidity(Double.parseDouble(value), unit);
	}
	
	private Pressure parsePressure(Document doc) {
		String value = doc.valueOf( "//current/pressure/@value" );
		String unit = doc.valueOf( "//current/pressure/@unit" );
		return new Pressure(Double.parseDouble(value), unit);
	}
	
	private Precipitation parsePrecipitation(Document doc) {
		String value = doc.valueOf( "//current/precipitation/@value" );
		String mode = doc.valueOf( "//current/precipitation/@mode" );
		return new Precipitation(Double.parseDouble(value), mode);
	}
	
	private Coordinates parseCoordinates(Document doc) {
		String lon = doc.valueOf( "//current/city/coord/@lon" );
		String lat = doc.valueOf( "//current/city/coord/@lat" );
		return new Coordinates(Double.parseDouble(lon), Double.parseDouble(lat));
	}
	
	private TemperatureUnit parseTemperatureUnit(Document doc) {
		String unit = doc.valueOf( "//current/temperature/@unit" );
		return UnitInterpriter.interpriterTemperatureUnit(unit);
	}
}
