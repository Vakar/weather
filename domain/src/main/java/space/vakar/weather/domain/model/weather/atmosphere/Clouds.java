package space.vakar.weather.domain.model.weather.atmosphere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
public class Clouds implements Serializable {

  private static final long serialVersionUID = -3772304563756023481L;

  @Column(name = "CLOUDINESS")
  private BigDecimal value;

  @Enumerated(EnumType.STRING)
  @Column(name = "CLOUDINESS_UNIT")
  private CloudinessUnit unit;

  public Clouds() {
  }

  public Clouds(BigDecimal value, CloudinessUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public CloudinessUnit getUnit() {
    return unit;
  }


  public void setUnit(CloudinessUnit unit) {
    this.unit = unit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Clouds) {
      Clouds that = (Clouds) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Clouds [value=%s, unit=%s]";
    return String.format(format, value, unit);
  }
}
