package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Coord implements Serializable {

  /** City geographic location, longitude. */
  @SerializedName("lon")
  @Expose
  private BigDecimal lon;

  /** City geographic location, latitude. */
  @SerializedName("lat")
  @Expose
  private BigDecimal lat;
}
