package space.vakar.weather.persistence.entities.weather.wind;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class WindSpeed implements Serializable {

  private static final long serialVersionUID = 5373165754036858665L;

  @Column(name = "WIND_SPEED")
  private BigDecimal value;

  @Column(name = "WIND_SPEED_UNIT")
  private SpeedUnit speedUnit;

  @Column(name = "WIND_NAME")
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
          && Objects.equals(this.speedUnit, that.speedUnit) && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "WindSpeed [value=%s, speedUnit=%s, name=%s]";
    return String.format(format, value, speedUnit, name);
  }

}
