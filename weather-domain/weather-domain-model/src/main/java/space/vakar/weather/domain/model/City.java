package space.vakar.weather.domain.model;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {

  private int id;
  private String name;
  private String country;

  /**
   * Default {City} constructor.
   */
  public City() {}

  /**
   * This constructor creates {City} entity.
   * 
   * @param id city id
   * @param name city name
   * @param country country code (GB, JP etc.)
   */
  public City(int id, String name, String country) {
    this.id = id;
    this.name = name;
    this.country = country;
  }

  /**
   * Get city id.
   * @return city id
   */
  public int getId() {
    return id;
  }

  /**
   * Set city id.
   * @param id city id.
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get city name.
   * @return city name
   */
  public String getName() {
    return name;
  }

  /**
   * Set city name.
   * @param name city name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get country code (GB, JP etc.).
   * @return country country code
   */
  public String getCountry() {
    return country;
  }

  /**
   * Set country code (GB, JP etc.).
   * @param country country code
   */
  public void setCountry(String country) {
    this.country = country;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof City)) {
      return false;
    }
    City that = (City) obj;
    return id == that.id && Objects.equals(name, that.name)
        && Objects.equals(country, that.country);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, country);
  }

  @Override
  public String toString() {
    return "CityLocation{" + "id=" + id + ", name='" + name + '\'' + ", country='" + country + '\''
        + '}';
  }
}
