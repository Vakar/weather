package space.vakar.weather.domain.model.impl.temperature;

import java.math.BigDecimal;
import java.util.Objects;

import space.vakar.weather.domain.model.impl.DomainObject;

public class Temperature extends DomainObject {

  private BigDecimal value;
  private TemperatureUnit unit;

  public Temperature() {

  }

  public Temperature(BigDecimal value, TemperatureUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public TemperatureUnit getUnit() {
    return unit;
  }

  public void setUnit(TemperatureUnit unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, value, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Temperature) {
      Temperature that = (Temperature) object;
      return this.id == that.id && Objects.equals(this.value, that.value)
          && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Temperature [id=%s, value=%s, unit=%s]";
    return String.format(format, id, value, unit);
  }

}
