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
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class WeatherDto implements Serializable {

  @SerializedName("coord")
  @Expose
  private Coord coord;

  @SerializedName("weather")
  @Expose
  private List<Weather> weather = null;

  /** Base internal parameter. */
  @SerializedName("base")
  @Expose
  private String base;

  @SerializedName("main")
  @Expose
  private Main main;

  /** Visibility in meters. */
  @SerializedName("visibility")
  @Expose
  private BigDecimal visibility;

  @SerializedName("wind")
  @Expose
  private Wind wind;

  @SerializedName("clouds")
  @Expose
  private Clouds clouds;

  /** Time of data calculation in seconds, unix, UTC. */
  @SerializedName("dt")
  @Expose
  private long dt;

  @SerializedName("sys")
  @Expose
  private Sys sys;

  /** Shift in seconds from UTC. */
  @SerializedName("timezone")
  @Expose
  private int timezone;

  /** City ID. */
  @SerializedName("id")
  @Expose
  private int id;

  /** City name. */
  @SerializedName("name")
  @Expose
  private String name;

  /** HTTP response code. */
  @SerializedName("cod")
  @Expose
  private int cod;
}
