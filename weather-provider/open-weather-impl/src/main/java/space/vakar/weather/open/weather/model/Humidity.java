package space.vakar.weather.open.weather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Objects;

@XmlRootElement
public class Humidity {

  /** Humidity value. */
  private BigDecimal value;

  /** OpenWeather represent this parameter in %. */
  private String unit;

  public Humidity() {}

  public Humidity(BigDecimal value, String unit) {
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
    if (object instanceof Humidity) {
      Humidity that = (Humidity) object;
      return Objects.equals(this.value, that.value) && Objects.equals(this.unit, that.unit);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Humidity [value=%s, unit=%s]";
    return String.format(format, value, unit);
  }
}
