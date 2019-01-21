package space.vakar.weather.domain.model.weather.atmosphere;

import java.math.BigDecimal;
import java.util.Objects;

public class Visibility {

  private BigDecimal value;

  private VisibilityUnit unit;

  public Visibility() {
  }

  public Visibility(BigDecimal value, VisibilityUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }
  
  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public VisibilityUnit getUnit() {
    return unit;
  }

  public void setUnit(VisibilityUnit unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Visibility) {
      Visibility that = (Visibility) object;
      return Objects.equals(this.value, that.value) && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Visibility [value=%s, unit=%s]";
    return String.format(format, value, unit);
  }

}
