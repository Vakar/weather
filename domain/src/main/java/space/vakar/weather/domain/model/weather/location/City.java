package space.vakar.weather.domain.model.weather.location;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class City implements Serializable {

  private static final long serialVersionUID = 885590064444808255L;

  @Column(name = "CITY_ID")
  private int id;

  @Column(name = "CITY_NAME")
  private String name;

  public City() {
  }

  public City(String name) {
    this.name = name;
  }

  public City(int id, String name) {
    this.id = id;
    this.name = name;
  }

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

  @Override
  public int hashCode() {
    return Objects.hash(id, name);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof City) {
      City that = (City) object;
      return this.id == that.id && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "City [id=%s, name=%s]";
    return String.format(format, id, name);
  }
}
