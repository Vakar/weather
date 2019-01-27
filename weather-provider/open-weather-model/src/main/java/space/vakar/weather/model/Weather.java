package space.vakar.weather.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Weather {

  /** Weather condition id. */
  private int number;

  /** Weather condition name. */
  private String value;

  /** Weather icon id. */
  private String icon;

  public Weather() {}

  public Weather(int number, String value, String icon) {
    this.number = number;
    this.value = value;
    this.icon = icon;
  }

  public int getNumber() {
    return number;
  }

  @XmlAttribute
  public void setNumber(int number) {
    this.number = number;
  }

  public String getValue() {
    return value;
  }

  @XmlAttribute
  public void setValue(String value) {
    this.value = value;
  }

  public String getIcon() {
    return icon;
  }

  @XmlAttribute
  public void setIcon(String icon) {
    this.icon = icon;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, value, icon);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Weather) {
      Weather that = (Weather) object;
      return this.number == that.number
          && Objects.equals(this.value, that.value)
          && Objects.equals(this.icon, that.icon);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Weather [number=%s, value=%s, icon=%s]";
    return String.format(format, number, value, icon);
  }
}
