
package org.open.weather.json.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class WeatherDTO implements Serializable {

	private final static long serialVersionUID = 2946557401046761713L;

	@SerializedName("coord")
	@Expose
	private Coord coord;
	@SerializedName("weather")
	@Expose
	private List<Weather> weather = null;
	@SerializedName("base")
	@Expose
	private String base;
	@SerializedName("main")
	@Expose
	private Main main;
	@SerializedName("visibility")
	@Expose
	private int visibility;
	@SerializedName("wind")
	@Expose
	private Wind wind;
	@SerializedName("clouds")
	@Expose
	private Clouds clouds;
	@SerializedName("dt")
	@Expose
	private int dt;
	@SerializedName("sys")
	@Expose
	private Sys sys;
	@SerializedName("timezone")
	@Expose
	private int timezone;
	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("cod")
	@Expose
	private int cod;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WeatherDTO other = (WeatherDTO) obj;
		return Objects.equals(base, other.base) && Objects.equals(clouds, other.clouds) && cod == other.cod
				&& Objects.equals(coord, other.coord) && dt == other.dt && id == other.id
				&& Objects.equals(main, other.main) && Objects.equals(name, other.name)
				&& Objects.equals(sys, other.sys) && timezone == other.timezone && visibility == other.visibility
				&& Objects.equals(weather, other.weather) && Objects.equals(wind, other.wind);
	}

	public String getBase() {
		return base;
	}

	public Clouds getClouds() {
		return clouds;
	}

	public int getCod() {
		return cod;
	}

	public Coord getCoord() {
		return coord;
	}

	public int getDt() {
		return dt;
	}

	public int getId() {
		return id;
	}

	public Main getMain() {
		return main;
	}

	public String getName() {
		return name;
	}

	public Sys getSys() {
		return sys;
	}

	public int getTimezone() {
		return timezone;
	}

	public int getVisibility() {
		return visibility;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public Wind getWind() {
		return wind;
	}

	@Override
	public int hashCode() {
		return Objects.hash(base, clouds, cod, coord, dt, id, main, name, sys, timezone, visibility, weather, wind);
	}

	public void setBase(String base) {
		this.base = base;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public void setCoord(Coord coord) {
		this.coord = coord;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMain(Main main) {
		this.main = main;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setSys(Sys sys) {
		this.sys = sys;
	}

	public void setTimezone(int timezone) {
		this.timezone = timezone;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	@Override
	public String toString() {
		return String.format(
				"WeatherDTO [coord=%s, weather=%s, base=%s, main=%s, visibility=%s, wind=%s, clouds=%s, dt=%s, sys=%s, timezone=%s, id=%s, name=%s, cod=%s]",
				coord, weather, base, main, visibility, wind, clouds, dt, sys, timezone, id, name, cod);
	}

	public WeatherDTO withBase(String base) {
		this.base = base;
		return this;
	}

	public WeatherDTO withClouds(Clouds clouds) {
		this.clouds = clouds;
		return this;
	}

	public WeatherDTO withCod(int cod) {
		this.cod = cod;
		return this;
	}

	public WeatherDTO withCoord(Coord coord) {
		this.coord = coord;
		return this;
	}

	public WeatherDTO withDt(int dt) {
		this.dt = dt;
		return this;
	}

	public WeatherDTO withId(int id) {
		this.id = id;
		return this;
	}

	public WeatherDTO withMain(Main main) {
		this.main = main;
		return this;
	}

	public WeatherDTO withName(String name) {
		this.name = name;
		return this;
	}

	public WeatherDTO withSys(Sys sys) {
		this.sys = sys;
		return this;
	}

	public WeatherDTO withTimezone(int timezone) {
		this.timezone = timezone;
		return this;
	}

	public WeatherDTO withVisibility(int visibility) {
		this.visibility = visibility;
		return this;
	}

	public WeatherDTO withWeather(List<Weather> weather) {
		this.weather = weather;
		return this;
	}

	public WeatherDTO withWind(Wind wind) {
		this.wind = wind;
		return this;
	}

}
