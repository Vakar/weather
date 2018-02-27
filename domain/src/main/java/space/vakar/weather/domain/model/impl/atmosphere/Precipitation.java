package space.vakar.weather.domain.model.impl.atmosphere;

import java.math.BigDecimal;
import java.util.Objects;

import space.vakar.weather.domain.model.impl.DomainObject;

public class Precipitation extends DomainObject {

  private BigDecimal value;
  private String mode;

  public Precipitation() {
  }

  /**
   * Constructor.
   * 
   * @param value millimeters of precipitation
   * @param mode 'no' or 'rain', 'snow' act...
   */
  public Precipitation(BigDecimal value, String mode) {
    this.value = value;
    this.mode = mode;
  }

  public BigDecimal getValue() {
    return value;
  }

  public void setValue(BigDecimal value) {
    this.value = value;
  }

  public String getMode() {
    return mode;
  }

  public void setMode(String mode) {
    this.mode = mode;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, value, mode);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Precipitation) {
      Precipitation that = (Precipitation) object;
      return this.id == that.id && Objects.equals(this.value, that.value)
          && Objects.equals(this.mode, that.mode);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Precipitation [id=%s, value=%s, mode=%s]";
    return String.format(format, id, value, mode);
  }
}
