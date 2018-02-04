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
			int visibility, double precipitation) {
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
		return Objects.hash(id, humidity, pressure, 
				visibility, precipitation, sun);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Atmosphere) {
			final Atmosphere other = (Atmosphere) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(humidity, other.humidity)
					&& Objects.equals(pressure, other.pressure)
					&& Objects.equals(visibility, other.visibility)
					&& Objects.equals(precipitation, other.precipitation)
					&& Objects.equals(sun, other.sun);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Atmosphere [id=" + id + ", humidity=" + humidity + ", pressure=" + pressure + ", visibility="
				+ visibility + ", precipitation=" + precipitation + ", sun=" + sun + "]";
	}
}
