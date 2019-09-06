
package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Main implements Serializable {

  private static final long serialVersionUID = 6029719905243037484L;

  @SerializedName("temp")
  @Expose
  private BigDecimal temp;
  @SerializedName("pressure")
  @Expose
  private BigDecimal pressure;
  @SerializedName("humidity")
  @Expose
  private BigDecimal humidity;
  @SerializedName("temp_min")
  @Expose
  private BigDecimal tempMin;
  @SerializedName("temp_max")
  @Expose
  private BigDecimal tempMax;

  /**
   * Get humidity, %.
   * 
   * @return humidity, %
   */
  public BigDecimal getHumidity() {
    return humidity;
  }

  /**
   * Set humidity, %.
   * 
   * @param humidity humidity, %
   */
  public void setHumidity(BigDecimal humidity) {
    this.humidity = humidity;
  }

  /**
   * Get atmospheric pressure, hPa.
   * 
   * @return atmospheric pressure, hPa
   */
  public BigDecimal getPressure() {
    return pressure;
  }

  /**
   * Set atmospheric pressure, hPa.
   * 
   * @param pressure atmospheric pressure, hPa
   */
  public void setPressure(BigDecimal pressure) {
    this.pressure = pressure;
  }

  /**
   * Get temperature. Unit: Kelvin.
   * 
   * @return temperature. Unit: Kelvin.
   */
  public BigDecimal getTemp() {
    return temp;
  }

  /**
   * Set temperature. Unit: Kelvin.
   * 
   * @param temp temperature. Unit: Kelvin.
   */
  public void setTemp(BigDecimal temp) {
    this.temp = temp;
  }

  /**
   * Get maximum temperature at the moment. Unit: Kelvin.
   * 
   * @return maximum temperature at the moment. Unit: Kelvin.
   */
  public BigDecimal getTempMax() {
    return tempMax;
  }

  /**
   * Set maximum temperature at the moment. Unit: Kelvin.
   * 
   * @param tempMax maximum temperature at the moment. Unit: Kelvin.
   */
  public void setTempMax(BigDecimal tempMax) {
    this.tempMax = tempMax;
  }

  /**
   * Get minimum temperature at the moment. Unit: Kelvin.
   * 
   * @return minimum temperature at the moment. Unit: Kelvin.
   */
  public BigDecimal getTempMin() {
    return tempMin;
  }

  /**
   * Set minimum temperature at the moment. Unit: Kelvin.
   * 
   * @param tempMin minimum temperature at the moment. Unit: Kelvin.
   */
  public void setTempMin(BigDecimal tempMin) {
    this.tempMin = tempMin;
  }



  @Override
  public int hashCode() {
    return Objects.hash(humidity, pressure, temp, tempMax, tempMin);
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
    Main other = (Main) obj;
    return Objects.equals(humidity, other.humidity) && Objects.equals(pressure, other.pressure)
        && Objects.equals(temp, other.temp) && Objects.equals(tempMax, other.tempMax)
        && Objects.equals(tempMin, other.tempMin);
  }

  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Main [temp=").append(temp).append(", pressure=").append(pressure)
        .append(", humidity=").append(humidity).append(", tempMin=").append(tempMin)
        .append(", tempMax=").append(tempMax).append("]");
    return builder.toString();
  }

  /**
   * Set humidity, %.
   * 
   * @param humidity humidity, %
   */
  public Main withHumidity(BigDecimal humidity) {
    this.humidity = humidity;
    return this;
  }

  /**
   * Set atmospheric pressure, hPa.
   * 
   * @param pressure atmospheric pressure, hPa
   */
  public Main withPressure(BigDecimal pressure) {
    this.pressure = pressure;
    return this;
  }

  /**
   * Set temperature. Unit: Kelvin.
   * 
   * @param temp temperature. Unit: Kelvin.
   */
  public Main withTemp(BigDecimal temp) {
    this.temp = temp;
    return this;
  }

  /**
   * Set maximum temperature at the moment. Unit: Kelvin.
   * 
   * @param tempMax maximum temperature at the moment. Unit: Kelvin.
   */
  public Main withTempMax(BigDecimal tempMax) {
    this.tempMax = tempMax;
    return this;
  }

  /**
   * Set minimum temperature at the moment. Unit: Kelvin.
   * 
   * @param tempMin minimum temperature at the moment. Unit: Kelvin.
   */
  public Main withTempMin(BigDecimal tempMin) {
    this.tempMin = tempMin;
    return this;
  }

}
