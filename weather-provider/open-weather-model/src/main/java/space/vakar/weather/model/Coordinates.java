package space.vakar.weather.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Coordinates {

  /** Geographical location, longitude. */
  private BigDecimal longitude;

  /** Geographical location, latitude. */
  private BigDecimal latitude;

  public Coordinates() {}

  public Coordinates(BigDecimal longitude, BigDecimal latitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  @XmlAttribute(name = "lon")
  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  @XmlAttribute(name = "lat")
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
