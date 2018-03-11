package space.vakar.weather.domain.model.weather.atmosphere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Humidity implements Serializable {

  private static final long serialVersionUID = 94070687448884334L;

  @Column(name = "HUMIDITY")
  private BigDecimal value;

  @Enumerated(EnumType.STRING)
  @Column(name = "HUMIDITY_UNIT")
  private HumidityUnit unit;

  public Humidity() {
  }

  /**
   * Constructor.
   *
   * @param value from 0 to 100
   * @param unit percents %
   */
  public Humidity(BigDecimal value, HumidityUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public HumidityUnit getUnit() {
    return unit;
  }

  public void setUnit(HumidityUnit unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Humidity) {
      Humidity that = (Humidity) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Humidity [value=%s, unit=%s]";
    return String.format(format, value, unit);
  }
}
