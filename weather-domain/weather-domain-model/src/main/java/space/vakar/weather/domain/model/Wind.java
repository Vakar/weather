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
public class Wind implements Serializable {

  /** Wind speed. Unit: meter/sec. */
  @SerializedName("speed")
  @Expose
  private BigDecimal speed;

  /** Wind direction, degrees (from 0 to 360 where 0 is North). */
  @SerializedName("deg")
  @Expose
  private BigDecimal deg;
}
