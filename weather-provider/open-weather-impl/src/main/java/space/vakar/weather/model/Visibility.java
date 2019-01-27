package space.vakar.weather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.Objects;

@XmlRootElement
public class Visibility {

  /** Visibility in meters. */
  private BigDecimal value;

  public Visibility() {}

  public Visibility(BigDecimal value) {
    this.value = value;
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
    if (object instanceof Visibility) {
      Visibility that = (Visibility) object;
      return Objects.equals(this.value, that.value);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Visibility [value=%s]";
    return String.format(format, value);
  }
}
