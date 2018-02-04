package space.vakar.weather.domain;

import java.util.Objects;

public class Atmosphere {

	private int id;
	private Humidity humidity;
	private Pressure pressure;
	private int visibility;
	private double precipitation;
	private Sun sun;

	public Atmosphere() {
		setId(0);
		setHumidity(new Humidity());
		setPressure(new Pressure());
		setVisibility(0);
		setPrecipitation(0);
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

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double precipitation) {
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
		String format = "Atmosphere [id=%s, humidity=%s, pressure=%s, "
				+ "visibility=%s, precipitation=%s, sun=%s]";
		return String.format(format, id, humidity, pressure, 
				visibility, precipitation, sun);
	}
}
