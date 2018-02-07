package space.vakar.weather.domain;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Weather  implements Serializable{

	private int id;
	private Wind wind;
	private Atmosphere atmosphere;
	private City city;
	private Temperature temperature;
	private LocalDateTime lastUpdate;

	public Weather() {
		setId(0);
		setWind(new Wind());
		setAtmosphere(new Atmosphere());
		setCity(new City());
		setTemperature(new Temperature());
		setLastUpdate(LocalDateTime.MIN);
	}

	public Weather(Wind wind, Atmosphere atmosphere, City city, 
			Temperature temperature, LocalDateTime lastUpdate) {
		this();
		setWind(wind);
		setAtmosphere(atmosphere);
		setCity(city);
		setTemperature(temperature);
		setLastUpdate(lastUpdate);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Wind getWind() {
		return wind;
	}

	public void setWind(Wind wind) {
		this.wind = wind;
	}

	public Atmosphere getAtmosphere() {
		return atmosphere;
	}

	public void setAtmosphere(Atmosphere atmosphere) {
		this.atmosphere = atmosphere;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, wind, atmosphere, city, temperature, lastUpdate);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Weather) {
			Weather that = (Weather) object;
			return this.id == that.id && Objects.equals(this.wind, that.wind)
					&& Objects.equals(this.atmosphere, that.atmosphere) && Objects.equals(this.city, that.city)
					&& Objects.equals(this.temperature, that.temperature)
					&& Objects.equals(this.lastUpdate, that.lastUpdate);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Weather [id=%s, wind=%s, atmosphere=%s, "
				+ "city=%s, temperature=%s, lastUpdate=%s]";
		return String.format(format, id, wind, atmosphere, 
				city, temperature, lastUpdate);
	}
}
