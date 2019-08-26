
package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Wind implements Serializable {

  private static final long serialVersionUID = 2769601011851779264L;

  @SerializedName("speed")
  @Expose
  private BigDecimal speed;
  
  @SerializedName("deg")
  @Expose
  private BigDecimal deg;

  /**
   * Get wind direction, degrees (from 0 to 360).
   * @return wind direction, degrees (from 0 to 360)
   */
  public BigDecimal getDeg() {
    return deg;
  }

  /**
   * Get wind direction, degrees (from 0 to 360).
   * @param deg wind direction, degrees (from 0 to 360)
   */
  public void setDeg(BigDecimal deg) {
    this.deg = deg;
  }

  /**
   * Get wind speed. Unit: meter/sec.
   * @return wind speed meter/sec
   */
  public BigDecimal getSpeed() {
    return speed;
  }

  /**
   * Set wind speed. Unit: meter/sec.
   * @param speed wind speed meter/sec
   */
  public void setSpeed(BigDecimal speed) {
    this.speed = speed;
  }

  @Override
  public int hashCode() {
    return Objects.hash(deg, speed);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Wind other = (Wind) obj;
    return Objects.equals(deg, other.deg) && Objects.equals(speed, other.speed);
  }

  @Override
  public String toString() {
    return String.format("Wind [speed=%s, deg=%s]", speed, deg);
  }

  /**
   * Get wind direction, degrees (from 0 to 360).
   * @param deg wind direction, degrees (from 0 to 360)
   * @return this {Wind} object
   */
  public Wind withDeg(BigDecimal deg) {
    this.deg = deg;
    return this;
  }

  /**
   * Set wind speed. Unit: meter/sec.
   * @param speed wind speed meter/sec
   * @return this {Wind} object
   */
  public Wind withSpeed(BigDecimal speed) {
    this.speed = speed;
    return this;
  }

}
