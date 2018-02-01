package space.vakar.weather.domain;

import java.time.LocalDateTime;

public class Weather {

	private int id;
	private Wind wind;
	private Atmosphere atmosphere;
	private City city;
	private Temperature temperature;
	private LocalDateTime lastupdate;

	public Weather() {
		setId(0);
		setWind(new Wind());
		setAtmosphere(new Atmosphere());
		setCity(new City());
		setTemperature(new Temperature());
		setLastupdate(LocalDateTime.MIN);
	}

	public Weather(int id, Wind wind, Atmosphere atmosphere, City city, Temperature temperature,
			LocalDateTime lastupdate) {
		setId(id);
		setWind(wind);
		setAtmosphere(atmosphere);
		setCity(city);
		setTemperature(temperature);
		setLastupdate(lastupdate);
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

	public LocalDateTime getLastupdate() {
		return lastupdate;
	}

	public void setLastupdate(LocalDateTime lastupdate) {
		this.lastupdate = lastupdate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atmosphere == null) ? 0 : atmosphere.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + id;
		result = prime * result + ((lastupdate == null) ? 0 : lastupdate.hashCode());
		result = prime * result + ((temperature == null) ? 0 : temperature.hashCode());
		result = prime * result + ((wind == null) ? 0 : wind.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		if (atmosphere == null) {
			if (other.atmosphere != null)
				return false;
		} else if (!atmosphere.equals(other.atmosphere))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (id != other.id)
			return false;
		if (lastupdate == null) {
			if (other.lastupdate != null)
				return false;
		} else if (!lastupdate.equals(other.lastupdate))
			return false;
		if (temperature == null) {
			if (other.temperature != null)
				return false;
		} else if (!temperature.equals(other.temperature))
			return false;
		if (wind == null) {
			if (other.wind != null)
				return false;
		} else if (!wind.equals(other.wind))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Weather [id=" + id + ", wind=" + wind + ", atmosphere=" + atmosphere + ", city=" + city
				+ ", temperature=" + temperature + ", lastupdate=" + lastupdate + "]";
	}
}
