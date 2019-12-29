package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Main implements Serializable {

  /** Temperature. Unit: Kelvin. */
  @SerializedName("temp")
  @Expose
  private BigDecimal temp;

  /** Atmospheric pressure, hPa. */
  @SerializedName("pressure")
  @Expose
  private BigDecimal pressure;

  /** Humidity, %. */
  @SerializedName("humidity")
  @Expose
  private BigDecimal humidity;

  /** Minimum temperature at the moment. Unit: Kelvin. */
  @SerializedName("temp_min")
  @Expose
  private BigDecimal tempMin;

  /** Maximum temperature at the moment. Unit: Kelvin. */
  @SerializedName("temp_max")
  @Expose
  private BigDecimal tempMax;
}
