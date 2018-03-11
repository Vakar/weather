package space.vakar.weather.domain.model.weather;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import space.vakar.weather.domain.model.weather.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.weather.location.Location;
import space.vakar.weather.domain.model.weather.temperature.Temperature;
import space.vakar.weather.domain.model.weather.wind.Wind;

@Entity
@Table(name = "WEATHER")
public class Weather implements Serializable {

  private static final long serialVersionUID = -5844838912038162239L;

  @Id
  @GeneratedValue
  @Column(name = "ID")
  private int id;

  @Embedded
  private Wind wind;

  @Embedded
  private Location location;

  @Embedded
  private Atmosphere atmosphere;

  @Embedded
  private Temperature temperature;

  @Column(name = "MEASURING_TIME")
  private LocalDateTime measuringTime;

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
    this.measuringTime = lastUpdate;
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

  public LocalDateTime getMeasuringTime() {
    return measuringTime;
  }

  public void setMeasuringTime(LocalDateTime lastUpdate) {
    this.measuringTime = lastUpdate;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, wind, location, atmosphere, temperature, measuringTime);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Weather) {
      Weather that = (Weather) object;
      return this.id == that.id && Objects.equals(this.wind, that.wind)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.atmosphere, that.atmosphere)
          && Objects.equals(this.temperature, that.temperature)
          && Objects.equals(this.measuringTime, that.measuringTime);
    }
    return false;
  }

  @Override
  public String toString() {
    String format =
        "Weather [id=%s, wind=%s, location=%s, atmosphere=%s, " + "temperature=%s, lastUpdate=%s]";
    return String.format(format, id, wind, location, atmosphere, temperature, measuringTime);
  }
}
