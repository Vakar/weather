package space.vakar.weather.provider.openweather.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Gusts {

  /** Wind gusts speed, mps */
  private double value;

  public Gusts() {

  }

  public Gusts(double value) {
    setValue(value);
  }

  public double getValue() {
    return value;
  }

  @XmlAttribute
  public void setValue(double value) {
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
      return this.value == that.value;
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Gusts [value=%s]";
    return String.format(format, value);
  }
}
