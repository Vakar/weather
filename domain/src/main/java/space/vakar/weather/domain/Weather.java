package space.vakar.weather.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Weather {

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
		return Objects.hash(id, wind, atmosphere, 
				city, temperature, lastUpdate);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Weather) {
			final Weather other = (Weather) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(wind, other.wind)
					&& Objects.equals(atmosphere, other.atmosphere)
					&& Objects.equals(city, other.city)
					&& Objects.equals(temperature, other.temperature)
					&& Objects.equals(lastUpdate, other.lastUpdate);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String format = "Weather [id=%s, wind=%s, atmosphere=%s, "
				+ "city=%s, temperature=%s, lastUpdate=%s]";
		return String.format(format, id, wind, atmosphere, 
				city, temperature, lastUpdate);
	}
}
