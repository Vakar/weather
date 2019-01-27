package space.vakar.weather.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

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
