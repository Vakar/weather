package space.vakar.weather.domain.model.impl.atmosphere;

import java.math.BigDecimal;
import java.util.Objects;

import space.vakar.weather.domain.model.impl.DomainObject;

public class Humidity extends DomainObject {

  private BigDecimal value;
  private String unit;

  public Humidity() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param value from 0 to 100
   * @param unit percents %
   */
  public Humidity(BigDecimal value, String unit) {
    super();
    this.value = value;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, value, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Humidity) {
      Humidity that = (Humidity) object;
      return this.id == that.id && Objects.equals(this.value, that.value)
          && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Humidity [id=%s, value=%s, unit=%s]";
    return String.format(format, id, value, unit);
  }
}
