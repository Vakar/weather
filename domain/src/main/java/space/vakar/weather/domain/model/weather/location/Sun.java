package space.vakar.weather.domain.model.weather.location;

import java.time.LocalDateTime;
import java.util.Objects;
import space.vakar.weather.domain.model.weather.DomainObject;

public class Sun extends DomainObject {

  private LocalDateTime rise;
  private LocalDateTime set;

  public Sun() {

  }

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
    return Objects.hash(id, rise, set);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Sun) {
      Sun that = (Sun) object;
      return this.id == that.id && Objects.equals(this.rise, that.rise)
          && Objects.equals(this.set, that.set);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Sun [id=%s, rise=%s, set=%s]";
    return String.format(format, id, rise, set);
  }
}
