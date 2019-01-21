package space.vakar.weather.persistence.entities.weather.location;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
public class Location implements Serializable {

  private static final long serialVersionUID = 6124854045366813155L;

  @Embedded
  private Coordinates coordinates;

  @Embedded
  private Sun sun;

  @Embedded
  private City city;

  @Column(name = "COUNTRY")
  private String country;

  public Location() {

  }

  /**
   * Constructor.
   *
   */
  public Location(Coordinates coordinates, Sun sun, City city, String country) {
    this.coordinates = coordinates;
    this.sun = sun;
    this.city = city;
    this.country = country;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  public Sun getSun() {
    return sun;
  }

  public void setSun(Sun sun) {
    this.sun = sun;
  }

  public City getCity() {
    return city;
  }

  public void setCity(City city) {
    this.city = city;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public int hashCode() {
    return Objects.hash(coordinates, sun, city, country);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Location) {
      Location that = (Location) object;
      return Objects.equals(this.coordinates, that.coordinates)
          && Objects.equals(this.sun, that.sun) && Objects.equals(this.city, that.city)
          && Objects.equals(this.country, that.country);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Location [coord=%s, sun=%s, city=%s, country=%s]";
    return String.format(format, coordinates, sun, city, country);
  }
}
