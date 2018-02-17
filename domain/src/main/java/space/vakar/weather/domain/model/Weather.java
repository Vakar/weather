package space.vakar.weather.domain.model;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.validation.constraints.NotNull;

import space.vakar.weather.domain.api.Defaultable;
import space.vakar.weather.domain.model.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.location.Location;
import space.vakar.weather.domain.model.temperature.Temperature;
import space.vakar.weather.domain.model.wind.Wind;

public class Weather  extends DomainObject implements Defaultable<Weather>{

	@NotNull
	private Wind wind;
	
	@NotNull
	private Location location;
	
	@NotNull
	private Atmosphere atmosphere;
	
	@NotNull
	private Temperature temperature;
	
	@NotNull
	private LocalDateTime lastUpdate;

	public Weather() {

	}

	public Weather(Wind wind, Atmosphere atmosphere, Location location, 
			Temperature temperature, LocalDateTime lastUpdate) {
		setWind(wind);
		setAtmosphere(atmosphere);
		setLocation(location);
		setTemperature(temperature);
		setLastUpdate(lastUpdate);
	}
	
	public Weather defaultInstance() {
		setId(0);
		setWind(new Wind().defaultInstance());
		setAtmosphere(new Atmosphere().defaultInstance());
		setLocation(new Location().defaultInstance());
		setTemperature(new Temperature().defaultInstance());
		setLastUpdate(LocalDateTime.MIN);
		return this;
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

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, wind, location, atmosphere, temperature,
				lastUpdate);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Weather) {
			Weather that = (Weather) object;
			return this.id == that.id && Objects.equals(this.wind, that.wind)
					&& Objects.equals(this.location, that.location)
					&& Objects.equals(this.atmosphere, that.atmosphere)
					&& Objects.equals(this.temperature, that.temperature)
					&& Objects.equals(this.lastUpdate, that.lastUpdate);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Weather [id=%s, wind=%s, location=%s, atmosphere=%s, "
				+ "temperature=%s, lastUpdate=%s]";
		return String.format(format, id, wind, location, atmosphere, 
				temperature, lastUpdate);
	}
}
