package space.vakar.weather.domain.model.weather.wind;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class WindSpeed implements Serializable {

  private static final long serialVersionUID = 5373165754036858665L;

  private BigDecimal value;

  private SpeedUnit speedUnit;

  private String name;

  public WindSpeed() {}

  public WindSpeed(BigDecimal value, SpeedUnit speedUnit, String name) {
    this.value = value;
    this.speedUnit = speedUnit;
    this.name = name;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public SpeedUnit getSpeedUnit() {
    return speedUnit;
  }

  public void setSpeedUnit(SpeedUnit speedUnit) {
    this.speedUnit = speedUnit;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, speedUnit, name);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof WindSpeed) {
      WindSpeed that = (WindSpeed) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.speedUnit, that.speedUnit)
          && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "WindSpeed [value=%s, speedUnit=%s, name=%s]";
    return String.format(format, value, speedUnit, name);
  }
}
