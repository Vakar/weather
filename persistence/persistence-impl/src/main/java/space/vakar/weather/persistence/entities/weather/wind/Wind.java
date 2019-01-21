package space.vakar.weather.persistence.entities.weather.wind;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Wind implements Serializable {

  private static final long serialVersionUID = 506747802178514431L;

  @Embedded
  private WindSpeed speed;

  @Embedded
  private WindDirection direction;

  public Wind() {

  }

  /**
   * Constructor.
   */
  public Wind(WindSpeed speed, WindDirection direction) {
    this.speed = speed;
    this.direction = direction;
  }

  public WindSpeed getSpeed() {
    return speed;
  }

  public void setSpeed(WindSpeed speed) {
    this.speed = speed;
  }

  public WindDirection getDirection() {
    return direction;
  }

  public void setDirection(WindDirection direction) {
    this.direction = direction;
  }

  @Override
  public int hashCode() {
    return Objects.hash(speed, direction);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Wind) {
      Wind that = (Wind) object;
      return Objects.equals(this.speed, that.speed)
          && Objects.equals(this.direction, that.direction);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Wind [speed=%s, direction=%s]";
    return String.format(format, speed, direction);
  }
}
