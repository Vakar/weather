package space.vakar.weather.open.weather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Objects;

@XmlRootElement
public class Gusts {

  /** Wind gusts speed, mps. */
  private BigDecimal value;

  public Gusts() {}

  public Gusts(BigDecimal value) {
    setValue(value);
  }

  public BigDecimal getValue() {
    return value;
  }

  @XmlAttribute
  public void setValue(BigDecimal value) {
    this.value = value;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(value);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Gusts) {
      Gusts that = (Gusts) object;
      return Objects.equals(this.value, that.value);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Gusts [value=%s]";
    return String.format(format, value);
  }
}
