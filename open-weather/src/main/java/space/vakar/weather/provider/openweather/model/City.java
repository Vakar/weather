package space.vakar.weather.provider.openweather.model;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class City {

  /** City ID. */
  private int id;

  /** City name. */
  private String name;

  /** Country code (GB, JP etc.) */
  private String country;

  /** City sunrise & sunset. */
  private Sun sun;

  /** City geo location. */
  private Coordinates coordinates;

  public City() {

  }

  public City(int id, String name, String country, Sun sun, Coordinates coordinates) {
    this.id = id;
    this.name = name;
    this.country = country;
    this.sun = sun;
    this.coordinates = coordinates;
  }

  public int getId() {
    return id;
  }

  @XmlAttribute
  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  @XmlAttribute
  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  @XmlElement
  public void setCountry(String country) {
    this.country = country;
  }

  public Sun getSun() {
    return sun;
  }

  @XmlElement
  public void setSun(Sun sun) {
    this.sun = sun;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  @XmlElement(name = "coord")
  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country, sun, coordinates);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof City) {
      City that = (City) object;
      return this.id == that.id && Objects.equals(this.name, that.name)
          && Objects.equals(this.country, that.country) && Objects.equals(this.sun, that.sun)
          && Objects.equals(this.coordinates, that.coordinates);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "City [id=%s, name=%s, country=%s, sun=%s, coordinates=%s]";
    return String.format(format, id, name, country, sun, coordinates);
  }
}
