package space.vakar.weather.domain.model.weather.location;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class Sun implements Serializable {

  private static final long serialVersionUID = 4691313924623685852L;

  private LocalDateTime rise;

  private LocalDateTime set;

  public Sun() {}

  /**
   * Constructor.
   *
   * @param rise time of sunrise
   * @param set time of sunset
   */
  public Sun(LocalDateTime rise, LocalDateTime set) {
    this.rise = rise;
    this.set = set;
  }

  public LocalDateTime getRise() {
    return rise;
  }

  public void setRise(LocalDateTime rise) {
    this.rise = rise;
  }

  public LocalDateTime getSet() {
    return set;
  }

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
