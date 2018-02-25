package space.vakar.weather.domain.model.impl.wind;

import java.math.BigDecimal;
import java.util.Objects;

import space.vakar.weather.domain.model.impl.DomainObject;

public class WindSpeed extends DomainObject {

  private BigDecimal value;
  private String name;

  public WindSpeed() {
    super();
  }

  /**
   * Constructor.
   * 
   * @param value speed in mps
   * @param name wind speed full name
   */
  public WindSpeed(BigDecimal value, String name) {
    super();
    setValue(value);
    setName(name);
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, value, name);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof WindSpeed) {
      WindSpeed that = (WindSpeed) object;
      return this.id == that.id && Objects.equals(this.value, that.value)
          && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "WindSpeed [id=%s, value=%s, name=%s]";
    return String.format(format, id, value, name);
  }
}
