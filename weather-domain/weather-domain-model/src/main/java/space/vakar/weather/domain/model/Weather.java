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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Weather implements Serializable {

  /** Weather condition id. */
  @SerializedName("id")
  @Expose
  private int id;

  /** Group of weather parameters (Rain, Snow, Extreme etc.). */
  @SerializedName("main")
  @Expose
  private String main;

  /** Weather condition within the group. */
  @SerializedName("description")
  @Expose
  private String description;

  /** Weather icon name. */
  @SerializedName("icon")
  @Expose
  private String icon;
}
