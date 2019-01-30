package space.vakar.open.weather.model;

import space.vakar.open.weather.model.adapters.LocalDateTimeAdapter;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;
import java.util.Objects;

@XmlRootElement
public class Sun {

  /** Sunrise time. */
  private LocalDateTime rise;

  /** Sunset time. */
  private LocalDateTime set;

  public Sun() {}

  public Sun(LocalDateTime rise, LocalDateTime set) {
    this.rise = rise;
    this.set = set;
  }

  public LocalDateTime getRise() {
    return rise;
  }

  @XmlAttribute
  @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
  public void setRise(LocalDateTime rise) {
    this.rise = rise;
  }

  public LocalDateTime getSet() {
    return set;
  }

  @XmlAttribute
  @XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
  public void setSet(LocalDateTime set) {
    this.set = set;
  }

  @Override
  public int hashCode() {
    return Objects.hash(rise, set);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Sun) {
      Sun that = (Sun) object;
      return Objects.equals(this.rise, that.rise) && Objects.equals(this.set, that.set);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Sun [rise=%s, set=%s]";
    return String.format(format, rise, set);
  }
}