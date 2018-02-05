package space.vakar.weather.domain;

import java.util.Objects;

public class Atmosphere {

	private int id;
	private Humidity humidity;
	private Pressure pressure;
	private double visibility;
	private Precipitation precipitation;
	private Sun sun;

	public Atmosphere() {
		setId(0);
		setHumidity(new Humidity());
		setPressure(new Pressure());
		setVisibility(0);
		setPrecipitation(new Precipitation());
		setSun(new Sun());
	}

	public Atmosphere(Humidity humidity, Pressure pressure, 
			int visibility, Precipitation precipitation) {
		this();
		setHumidity(humidity);
		setPressure(pressure);
		setVisibility(visibility);
		setPrecipitation(precipitation);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Humidity getHumidity() {
		return humidity;
	}

	public void setHumidity(Humidity humidity) {
		this.humidity = humidity;
	}

	public Pressure getPressure() {
		return pressure;
	}

	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public Precipitation getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(Precipitation precipitation) {
		this.precipitation = precipitation;
	}

	public Sun getSun() {
		return sun;
	}

	public void setSun(Sun sun) {
		this.sun = sun;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, humidity, pressure, visibility, precipitation, sun);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Atmosphere) {
			Atmosphere that = (Atmosphere) object;
			return this.id == that.id && Objects.equals(this.humidity, that.humidity)
					&& Objects.equals(this.pressure, that.pressure) && this.visibility == that.visibility
					&& Objects.equals(this.precipitation, that.precipitation) && Objects.equals(this.sun, that.sun);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Atmosphere [id=%s, humidity=%s, pressure=%s, visibility=%s, precipitation=%s, sun=%s]";
		return String.format(format, id, humidity, pressure, visibility, precipitation, sun);
	}

	
}
