package space.vakar.weather.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Pressure {

  /** Pressure value. */
  private BigDecimal value;

  /** OpenWeather pressure unit is hPa. */
  private String unit;

  public Pressure() {}

  public Pressure(BigDecimal value, String unit) {
    this.value = value;
    this.unit = unit;
  }

  public BigDecimal getValue() {
    return value;
  }

  @XmlAttribute
  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getUnit() {
    return unit;
  }

  @XmlAttribute
  public void setUnit(String unit) {
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
      return Objects.equals(this.value, that.value) && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Pressure [value=%s, unit=%s]";
    return String.format(format, value, unit);
  }
}
