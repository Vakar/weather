package space.vakar.weather.domain;

import java.time.LocalDateTime;

import utils.UnitInterpriter;

public class WeatherBuilder {
	
	private String cityId;
	private String cityName;
	private String coordinatesLongtitute;
	private String coordinatesLatitute;
	private String country;
	private String sunRise;
	private String sunSet;
	private String temperatureValue;
	private String temperatureUnit;
	private String humidityValue;
	private String humidityUnit;
	private String pressureValue;
	private String pressureUnit;
	private String windSpeedValue;
	private String windSpeedName;
	private String gustsValue;
	private String windDirectionValue;
	private String windDirectionCode;
	private String windDirectionName;
	private String cloudsValue;
	private String cloudsName;
	private String visibilityValue;
	private String precipitationValue;
	private String precipitationMode;
	private String weatherValue;
	private String lastUpdateValue;
	
	private WeatherBuilder() {
		cityId = "";
		cityName = "";
		coordinatesLongtitute = "";
		coordinatesLatitute = "";
		country = "";
		sunRise = "";
		sunSet = "";
		temperatureValue = "";
		temperatureUnit = "";
		humidityValue = "";
		humidityUnit = "";
		pressureValue = "";
		pressureUnit = "";
		windSpeedValue = "";
		windSpeedName = "";
		gustsValue = "";
		windDirectionValue = "";
		windDirectionCode = "";
		windDirectionName = "";
		cloudsValue = "";
		cloudsName = "";
		visibilityValue = "";
		precipitationValue = "";
		precipitationMode = "";
		weatherValue = "";
		lastUpdateValue = "";
	}
	
	public WeatherBuilder cityId(String cityId) {
		this.cityId = cityId;
		return this;
	}
	
	public WeatherBuilder cityName(String cityName) {
		this.cityName = cityName;
		return this;
	}
	
	public WeatherBuilder coordinatesLongtitute(String coordinatesLongtitute) {
		this.coordinatesLongtitute = coordinatesLongtitute;
		return this;
	}
	
	public WeatherBuilder coordinatesLatitute(String coordinatesLatitute) {
		this.coordinatesLatitute = coordinatesLatitute;
		return this;
	}
	
	public WeatherBuilder country(String country) {
		this.country = country;
		return this;
	}
	
	public WeatherBuilder sunRise(String sunRise) {
		this.sunRise = sunRise;
		return this;
	}
	
	public WeatherBuilder sunSet(String sunSet) {
		this.sunSet = sunSet;
		return this;
	}
	
	public WeatherBuilder temperatureValue(String temperatureValue) {
		this.temperatureValue = temperatureValue;
		return this;
	}
	
	public WeatherBuilder temperatureUnit(String temperatureUnit) {
		this.temperatureUnit = temperatureUnit;
		return this;
	}
	
	public WeatherBuilder humidityValue(String humidityValue) {
		this.humidityValue = humidityValue;
		return this;
	}
	
	public WeatherBuilder humidityUnit(String humidityUnit) {
		this.humidityUnit = humidityUnit;
		return this;
	}
	
	public WeatherBuilder pressureValue(String pressureValue) {
		this.pressureValue = pressureValue;
		return this;
	}
	
	public WeatherBuilder pressureUnit(String pressureUnit) {
		this.pressureUnit = pressureUnit;
		return this;
	}
	
	public WeatherBuilder windSpeedValue(String windSpeedValue) {
		this.windSpeedValue = windSpeedValue;
		return this;
	}
	
	public WeatherBuilder windSpeedName(String windSpeedName) {
		this.windSpeedName = windSpeedName;
		return this;
	}
	
	public WeatherBuilder gustsValue(String gustsValue) {
		this.gustsValue = gustsValue;
		return this;
	}
	
	public WeatherBuilder windDirectionValue(String windDirectionValue) {
		this.windDirectionValue = windDirectionValue;
		return this;
	}
	
	public WeatherBuilder windDirectionCode(String windDirectionCode) {
		this.windDirectionCode = windDirectionCode;
		return this;
	}
	
	public WeatherBuilder windDirectionName(String windDirectionName) {
		this.windDirectionName = windDirectionName;
		return this;
	}
	
	public WeatherBuilder cloudsName(String cloudsName) {
		this.cloudsName = cloudsName;
		return this;
	}
	
	public WeatherBuilder cloudsValue(String cloudsValue) {
		this.cloudsValue = cloudsValue;
		return this;
	}
	
	public WeatherBuilder visibilityValue(String visibilityValue) {
		this.visibilityValue = visibilityValue;
		return this;
	}
	
	public WeatherBuilder precipitationValue(String precipitationValue) {
		this.precipitationValue = precipitationValue;
		return this;
	}
	
	public WeatherBuilder precipitationMode(String precipitationMode) {
		this.precipitationMode = precipitationMode;
		return this;
	}
	
	public WeatherBuilder weatherValue(String weatherValue) {
		this.weatherValue = weatherValue;
		return this;
	}
	
	public WeatherBuilder lastUpdateValue(String lastUpdateValue) {
		this.lastUpdateValue = lastUpdateValue;
		return this;
	}
	
	public Weather build() {		
		WindSpeed windSpeed = new WindSpeed(Double.valueOf(windSpeedValue), windSpeedName);		
		WindDirection windDirection = new WindDirection(Double.valueOf(windDirectionValue), windDirectionCode, windDirectionName);		
		Wind wind = new Wind(windSpeed, windDirection);		
		Humidity humidity = new Humidity(Double.valueOf(humidityValue), humidityUnit);
		Pressure pressure = new Pressure(Double.valueOf(pressureValue), pressureUnit);	
		Precipitation precipitation = new Precipitation(Double.valueOf(precipitationValue), precipitationMode);
		Atmosphere atmosphere = new Atmosphere(humidity, pressure, Double.valueOf(visibilityValue), precipitation);		
		Coordinates coordinates = new Coordinates(Double.valueOf(coordinatesLongtitute), Double.valueOf(coordinatesLatitute));
		City city = new City(cityName, country, coordinates);
		TemperatureUnit temUnit = UnitInterpriter.interpriterTemperatureUnit(temperatureUnit);
		Temperature temperature = new Temperature(Double.valueOf(temperatureValue), temUnit);		
		LocalDateTime lastUpdate = LocalDateTime.parse(lastUpdateValue);
		return new Weather(wind, atmosphere, city, temperature, lastUpdate);
	}
}
