package space.vakar.weather.persistence.entities.weather.atmosphere;

import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import space.vakar.weather.domain.model.weather.atmosphere.VisibilityUnit;

@Embeddable
public class Visibility {

  @Column(name = "VISIBILITY")
  private BigDecimal value;

  @Enumerated(EnumType.STRING)
  @Column(name = "VISIBILITY_UNIT")
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
