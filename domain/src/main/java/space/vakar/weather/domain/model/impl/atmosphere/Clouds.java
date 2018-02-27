package space.vakar.weather.domain.model.impl.atmosphere;

import java.math.BigDecimal;
import java.util.Objects;

import space.vakar.weather.domain.model.impl.DomainObject;

public class Clouds extends DomainObject {

  private BigDecimal value;
  private String name;

  public Clouds() {
  }

  /**
   * Constructor.
   * 
   * @param value percent of sky in clouds
   * @param name the name of clouds condition for example 'clean sky'
   */
  public Clouds(BigDecimal value, String name) {
    this.value = value;
    this.name = name;
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
    if (object instanceof Clouds) {
      Clouds that = (Clouds) object;
      return this.id == that.id && Objects.equals(this.value, that.value)
          && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Clouds [id=%s, value=%s, name=%s]";
    return String.format(format, id, value, name);
  }
}
