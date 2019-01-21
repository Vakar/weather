package space.vakar.weather.domain.model.weather.temperature;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Temperature implements Serializable {

  private static final long serialVersionUID = -7591975165304837396L;

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
    return Objects.hash(value, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Temperature) {
      Temperature that = (Temperature) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Temperature [value=%s, unit=%s]";
    return String.format(format, value, unit);
  }

}
