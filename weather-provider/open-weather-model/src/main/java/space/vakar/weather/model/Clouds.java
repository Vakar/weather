package space.vakar.weather.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Clouds {

  /** Cloudiness. */
  private BigDecimal value;

  /** Name of the cloudiness. */
  private String name;

  public Clouds() {}

  public Clouds(BigDecimal value, String name) {
    this.value = value;
    this.name = name;
  }

  public BigDecimal getValue() {
    return value;
  }

  @XmlAttribute
  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  @XmlAttribute
  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value, name);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Clouds) {
      Clouds that = (Clouds) object;
      return Objects.equals(this.value, that.value) && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Clouds [value=%s, name=%s]";
    return String.format(format, value, name);
  }
}
