package space.vakar.weather.domain.model.atmosphere;

import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

import space.vakar.weather.domain.api.Defaultable;
import space.vakar.weather.domain.model.DomainObject;

public class Atmosphere extends DomainObject implements Defaultable<Atmosphere>{
	
	@NotNull
	private Humidity humidity;
	
	@NotNull
	private Pressure pressure;
	
	@PositiveOrZero
	private double visibility;
	
	@NotNull
	private Precipitation precipitation;
	
	@NotNull
	private Clouds clouds;

	public Atmosphere() {

	}

	public Atmosphere(Humidity humidity, Pressure pressure, 
			double visibility, Precipitation precipitation, Clouds clouds) {
		setHumidity(humidity);
		setPressure(pressure);
		setVisibility(visibility);
		setPrecipitation(precipitation);
		setClouds(clouds);
	}
	
	public Atmosphere defaultInstance() {
		setId(0);
		setHumidity(new Humidity().defaultInstance());
		setPressure(new Pressure().defaultInstance());
		setVisibility(Double.NaN);
		setPrecipitation(new Precipitation().defaultInstance());
		setClouds(new Clouds().defaultInstance());
		return this;
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

	public Clouds getClouds() {
		return clouds;
	}

	public void setClouds(Clouds clouds) {
		this.clouds = clouds;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, humidity, pressure, visibility, precipitation,
				clouds);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Atmosphere) {
			Atmosphere that = (Atmosphere) object;
			return this.id == that.id
					&& Objects.equals(this.humidity, that.humidity)
					&& Objects.equals(this.pressure, that.pressure)
					&& Double.compare(this.visibility , that.visibility) == 0 
					&& Objects.equals(this.precipitation, that.precipitation)
					&& Objects.equals(this.clouds, that.clouds);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Atmosphere [id=%s, humidity=%s, pressure=%s, "
				+ "visibility=%s, precipitation=%s, clouds=%s]";
		return String.format(format, id, humidity, pressure, 
				visibility, precipitation, clouds);
	}
}
