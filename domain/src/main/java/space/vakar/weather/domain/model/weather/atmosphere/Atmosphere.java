package space.vakar.weather.domain.model.weather.atmosphere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Atmosphere implements Serializable {

  private static final long serialVersionUID = 2780230800724985007L;

  private Humidity humidity;

  private Pressure pressure;

  private BigDecimal visibility;

  private Precipitation precipitation;

  private Clouds clouds;

  public Atmosphere() {
  }

  /**
   * Constructor.
   */
  public Atmosphere(Humidity humidity, Pressure pressure, BigDecimal visibility,
      Precipitation precipitation, Clouds clouds) {
    this.humidity = humidity;
    this.pressure = pressure;
    this.visibility = visibility;
    this.precipitation = precipitation;
    this.clouds = clouds;
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

  public BigDecimal getVisibility() {
    return visibility;
  }

  public void setVisibility(BigDecimal visibility) {
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
    return Objects.hash(humidity, pressure, visibility, precipitation, clouds);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Atmosphere) {
      Atmosphere that = (Atmosphere) object;
      return Objects.equals(this.humidity, that.humidity)
          && Objects.equals(this.pressure, that.pressure)
          && Objects.equals(this.visibility, that.visibility)
          && Objects.equals(this.precipitation, that.precipitation)
          && Objects.equals(this.clouds, that.clouds);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Atmosphere [humidity=%s, pressure=%s, "
        + "visibility=%s, precipitation=%s, clouds=%s]";
    return String.format(format, humidity, pressure, visibility, precipitation, clouds);
  }
}
