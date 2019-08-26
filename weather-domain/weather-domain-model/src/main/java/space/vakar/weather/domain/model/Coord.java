
package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Coord implements Serializable {

  private static final long serialVersionUID = -2824663640738017828L;

  @SerializedName("lon")
  @Expose
  private BigDecimal lon;
  @SerializedName("lat")
  @Expose
  private BigDecimal lat;

  /**
   * Default constructor.
   */
  public Coord() {}

  /**
   * Create object with given longitude and latitude.
   * @param lon longitude
   * @param lat latitude
   */
  public Coord(BigDecimal lon, BigDecimal lat) {
    this.lon = lon;
    this.lat = lat;
  }

  /**
   * Get city geographic location, latitude.
   * 
   * @return city geographic location, latitude
   */
  public BigDecimal getLat() {
    return lat;
  }

  /**
   * Set city geographic location, latitude.
   * 
   * @param lat city geographic location, latitude
   */
  public void setLat(BigDecimal lat) {
    this.lat = lat;
  }

  /**
   * Get city geographic location, longitude.
   * 
   * @return city geographic location, longitude
   */
  public BigDecimal getLon() {
    return lon;
  }

  /**
   * Set city geographic location, longitude.
   * 
   * @param lon city geographic location, longitude
   */
  public void setLon(BigDecimal lon) {
    this.lon = lon;
  }

  @Override
  public int hashCode() {
    return Objects.hash(lat, lon);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Coord other = (Coord) obj;
    return Objects.equals(lat, other.lat) && Objects.equals(lon, other.lon);
  }

  @Override
  public String toString() {
    return String.format("Coord [lon=%s, lat=%s]", lon, lat);
  }

}
