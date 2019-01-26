package space.vakar.weather.domain.model.weather.atmosphere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Precipitation implements Serializable {

  private static final long serialVersionUID = 7236263868458046925L;

  private BigDecimal value;

  private PrecipitationUnit unit;

  private String name;

  public Precipitation() {}

  public Precipitation(BigDecimal value, PrecipitationUnit unit, String name) {
    this.value = value;
    this.unit = unit;
    this.name = name;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public PrecipitationUnit getUnit() {
    return unit;
  }

  public void setUnit(PrecipitationUnit unit) {
    this.unit = unit;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit, name);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Precipitation) {
      Precipitation that = (Precipitation) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.unit, that.unit)
          && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Precipitation [value=%s, unit=%s, name=%s]";
    return String.format(format, value, unit, name);
  }
}
