package space.vakar.weather.domain.model.location;

import space.vakar.weather.domain.model.weather.location.Coordinates;

import java.io.Serializable;
import java.util.Objects;

public class CityLocation implements Serializable {

  private int id;
  private String name;
  private String country;
  private Coordinates coordinates;

  public CityLocation() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public Coordinates getCoordinates() {
    return coordinates;
  }

  public void setCoordinates(Coordinates coordinates) {
    this.coordinates = coordinates;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof CityLocation)) return false;
    CityLocation that = (CityLocation) o;
    return id == that.id
        && Objects.equals(name, that.name)
        && Objects.equals(country, that.country)
        && Objects.equals(coordinates, that.coordinates);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country, coordinates);
  }

  @Override
  public String toString() {
    return "CityLocation{"
        + "id="
        + id
        + ", name='"
        + name
        + '\''
        + ", country='"
        + country
        + '\''
        + ", coordinates="
        + coordinates
        + '}';
  }
}
