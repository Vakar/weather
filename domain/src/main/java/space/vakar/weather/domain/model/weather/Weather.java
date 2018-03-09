package space.vakar.weather.domain.model.weather;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import space.vakar.weather.domain.model.weather.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.weather.location.Location;
import space.vakar.weather.domain.model.weather.temperature.Temperature;
import space.vakar.weather.domain.model.weather.wind.Wind;

public class Weather implements Serializable {

  private static final long serialVersionUID = -5844838912038162239L;

  private int id;

  private Wind wind;

  private Location location;

  private Atmosphere atmosphere;

  private Temperature temperature;

  private LocalDateTime lastUpdate;

  public Weather() {
  }

  /**
   * Constructor.
   */
  public Weather(Wind wind, Location location, Atmosphere atmosphere, Temperature temperature,
      LocalDateTime lastUpdate) {
    this.wind = wind;
    this.location = location;
    this.atmosphere = atmosphere;
    this.temperature = temperature;
    this.lastUpdate = lastUpdate;
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
    return Objects.hash(wind, location, atmosphere, temperature, lastUpdate);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Weather) {
      Weather that = (Weather) object;
      return Objects.equals(this.wind, that.wind)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.atmosphere, that.atmosphere)
          && Objects.equals(this.temperature, that.temperature)
          && Objects.equals(this.lastUpdate, that.lastUpdate);
    }
    return false;
  }

  @Override
  public String toString() {
    String format =
        "Weather [wind=%s, location=%s, atmosphere=%s, " + "temperature=%s, lastUpdate=%s]";
    return String.format(format, wind, location, atmosphere, temperature, lastUpdate);
  }
}
