package space.vakar.weather.persistence.entities.weather.atmosphere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import space.vakar.weather.domain.model.weather.atmosphere.PressureUnit;

@Embeddable
public class Pressure implements Serializable {

  private static final long serialVersionUID = 4973909444937579375L;

  @Column(name = "PRESSURE")
  private BigDecimal value;

  @Enumerated(EnumType.STRING)
  @Column(name = "PRESSURE_UNIT")
  private PressureUnit unit;

  public Pressure() {
  }

  /**
   * Constructor.
   *
   * @param value atmosphere pressure
   * @param unit pressure unit
   */
  public Pressure(BigDecimal value, PressureUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public PressureUnit getUnit() {
    return unit;
  }

  public void setUnit(PressureUnit unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Pressure) {
      Pressure that = (Pressure) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Pressure [value=%s, unit=%s]";
    return String.format(format, value, unit);
  }
}
