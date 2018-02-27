package space.vakar.weather.domain.model.impl.location;

import java.util.Objects;

import space.vakar.weather.domain.model.impl.DomainObject;

public class City extends DomainObject {

  private String name;

  public City() {
  }

  public City(String name) {
    this.name = name;
  }

  public City(int id, String name) {
    super(id);
    this.name = name;
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
