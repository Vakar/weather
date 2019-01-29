package space.vakar.open.weather.model;

import space.vakar.weather.domain.model.weather.temperature.TemperatureUnit;
import space.vakar.open.weather.model.adapters.TemperatureUnitAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.math.BigDecimal;
import java.util.Objects;

public class Temperature {

  /** Temperature value. */
  private BigDecimal value;

  /**
   * Minimum temperature at the moment of calculation. This is deviation from 'temp' that is
   * possible for large cities and megalopolises geographically expanded (use these parameter
   * optionally).
   */
  private BigDecimal min;

  /**
   * Maximum temperature at the moment of calculation. This is deviation from 'temp' that is
   * possible for large cities and megalopolises geographically expanded (use these parameter
   * optionally).
   */
  private BigDecimal max;

  /** Unit of measurements. Possible value is Celsius, Kelvin, Fahrenheit. */
  private TemperatureUnit unit;

  public Temperature() {}

  public Temperature(BigDecimal value, BigDecimal min, BigDecimal max, TemperatureUnit unit) {
    this.value = value;
    this.min = min;
    this.max = max;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }

  @XmlAttribute
  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public BigDecimal getMin() {
    return min;
  }

  @XmlAttribute
  public void setMin(BigDecimal min) {
    this.min = min;
  }

  public BigDecimal getMax() {
    return max;
  }

  @XmlAttribute
  public void setMax(BigDecimal max) {
    this.max = max;
  }

  public TemperatureUnit getUnit() {
    return unit;
  }

  @XmlAttribute
  @XmlJavaTypeAdapter(TemperatureUnitAdapter.class)
  public void setUnit(TemperatureUnit unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, min, max, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Temperature) {
      Temperature that = (Temperature) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.min, that.min)
          && Objects.equals(this.max, that.max)
          && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Temperature [value=%s, min=%s, max=%s, unit=%s]";
    return String.format(format, value, min, max, unit);
  }
}
