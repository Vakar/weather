package utils;

import space.vakar.weather.openweather.model.City;
import space.vakar.weather.openweather.model.Clouds;
import space.vakar.weather.openweather.model.CurrentWeather;
import space.vakar.weather.openweather.model.Humidity;
import space.vakar.weather.openweather.model.LastUpdate;
import space.vakar.weather.openweather.model.Precipitation;
import space.vakar.weather.openweather.model.Pressure;
import space.vakar.weather.openweather.model.Temperature;
import space.vakar.weather.openweather.model.Visibility;
import space.vakar.weather.openweather.model.Weather;
import space.vakar.weather.openweather.model.Wind;

public class CurrentWeatherBuilder {

	private City city;
	private Temperature temperature;
	private Humidity humidity;
	private Pressure pressure;
	private Wind wind;
	private Clouds clouds;
	private Visibility visibility;
	private Precipitation precipitation;
	private Weather weather;
	private LastUpdate lastupdate;

	public CurrentWeatherBuilder city(City city) {
		this.city = city;
		return this;
	}

	public CurrentWeatherBuilder temperature(Temperature temperature) {
		this.temperature = temperature;
		return this;
	}

	public CurrentWeatherBuilder humidity(Humidity humidity) {
		this.humidity = humidity;
		return this;
	}

	public CurrentWeatherBuilder pressure(Pressure pressure) {
		this.pressure = pressure;
		return this;
	}

	public CurrentWeatherBuilder wind(Wind wind) {
		this.wind = wind;
		return this;
	}

	public CurrentWeatherBuilder clouds(Clouds clouds) {
		this.clouds = clouds;
		return this;
	}

	public CurrentWeatherBuilder visibility(Visibility visibility) {
		this.visibility = visibility;
		return this;
	}

	public CurrentWeatherBuilder precipitation(Precipitation precipitation) {
		this.precipitation = precipitation;
		return this;
	}

	public CurrentWeatherBuilder weather(Weather weather) {
		this.weather = weather;
		return this;
	}

	public CurrentWeatherBuilder lastupdate(LastUpdate lastupdate) {
		this.lastupdate = lastupdate;
		return this;
	}

	public CurrentWeather build() {
		CurrentWeather cw = new CurrentWeather();
		cw.setCity(this.city);
		cw.setTemperature(this.temperature);
		cw.setHumidity(this.humidity);
		cw.setPressure(this.pressure);
		cw.setWind(this.wind);
		cw.setClouds(this.clouds);
		cw.setVisibility(this.visibility);
		cw.setPrecipitation(this.precipitation);
		cw.setWeather(this.weather);
		cw.setLastupdate(this.lastupdate);
		return cw;
	}
}
