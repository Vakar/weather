package space.vakar.weather.domain.model.weather.atmosphere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Clouds implements Serializable {

  private static final long serialVersionUID = -3772304563756023481L;

  private BigDecimal value;

  private CloudinessUnit unit;

  private String cloudinessName;

  public Clouds() {
  }

  public Clouds(BigDecimal value, CloudinessUnit unit) {
    this.value = value;
    this.unit = unit;
  }

  public Clouds(BigDecimal value, CloudinessUnit unit, String cloudinessName) {
    this.value = value;
    this.unit = unit;
    this.cloudinessName = cloudinessName;
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

  public String getCloudinessName() {
    return cloudinessName;
  }

  public void setCloudinessName(String cloudinessName) {
    this.cloudinessName = cloudinessName;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, unit, cloudinessName);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Clouds) {
      Clouds that = (Clouds) object;
      return Objects.equals(this.value, that.value) && Objects.equals(this.unit, that.unit)
          && Objects.equals(this.cloudinessName, that.cloudinessName);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Clouds [value=%s, unit=%s, cloudiness_name=%s]";
    return String.format(format, value, unit, cloudinessName);
  }
}
