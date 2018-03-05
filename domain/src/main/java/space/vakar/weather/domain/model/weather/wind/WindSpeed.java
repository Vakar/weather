package space.vakar.weather.domain.model.weather.wind;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class WindSpeed implements Serializable {

  private static final long serialVersionUID = 5373165754036858665L;

  private BigDecimal value;
  private String name;

  public WindSpeed() {
  }

  /**
   * Constructor.
   *
   * @param value speed in mps
   * @param name wind speed full name
   */
  public WindSpeed(BigDecimal value, String name) {
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
    return Objects.hash(value, name);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof WindSpeed) {
      WindSpeed that = (WindSpeed) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.name, that.name);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "WindSpeed [value=%s, name=%s]";
    return String.format(format, value, name);
  }
}
