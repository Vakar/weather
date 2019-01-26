package space.vakar.weather.domain.model.weather.location;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Coordinates implements Serializable {

  private static final long serialVersionUID = -8819069034329335118L;

  private BigDecimal longitude;

  private BigDecimal latitude;

  public Coordinates() {}

  /**
   * Constructor.
   *
   * @param longitude geographic longitude
   * @param latitude geographic latitude
   */
  public Coordinates(BigDecimal longitude, BigDecimal latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  @Override
  public int hashCode() {
    return Objects.hash(longitude, latitude);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Coordinates) {
      Coordinates that = (Coordinates) object;
      return Objects.equals(this.longitude, that.longitude)
          && Objects.equals(this.latitude, that.latitude);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Coordinates [longitude=%s, latitude=%s]";
    return String.format(format, longitude, latitude);
  }
}
