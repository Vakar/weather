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
public class Sys implements Serializable {

  /**
   * Internal open weather parameter. More details: https://openweathermap.org/current#current_JSON.
   */
  @SerializedName("type")
  @Expose
  private int type;

  /**
   * Internal open weather parameter. More details: https://openweathermap.org/current#current_JSON.
   */
  @SerializedName("id")
  @Expose
  private int id;

  /**
   * Internal open weather parameter. More details: https://openweathermap.org/current#current_JSON.
   */
  @SerializedName("message")
  @Expose
  private BigDecimal message;

  /** Country code (GB, JP etc.). */
  @SerializedName("country")
  @Expose
  private String country;

  /** Sunrise time, unix, UTC. */
  @SerializedName("sunrise")
  @Expose
  private int sunrise;

  /** Sunset time, unix, UTC. */
  @SerializedName("sunset")
  @Expose
  private int sunset;
}
