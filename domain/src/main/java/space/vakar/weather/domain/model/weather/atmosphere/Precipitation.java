package space.vakar.weather.domain.model.weather.atmosphere;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Precipitation implements Serializable {

  private static final long serialVersionUID = 7236263868458046925L;

  private BigDecimal value;
  private String mode; // TODO remove this field

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
    return Objects.hash(value, mode);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Precipitation) {
      Precipitation that = (Precipitation) object;
      return Objects.equals(this.value, that.value)
          && Objects.equals(this.mode, that.mode);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "Precipitation [value=%s, mode=%s]";
    return String.format(format, value, mode);
  }
}
