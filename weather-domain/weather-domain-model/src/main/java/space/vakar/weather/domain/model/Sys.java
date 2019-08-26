
package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

public class Sys implements Serializable {

  private static final long serialVersionUID = -6633630464954791315L;

  @SerializedName("type")
  @Expose
  private int type;
  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("message")
  @Expose
  private BigDecimal message;
  @SerializedName("country")
  @Expose
  private String country;
  @SerializedName("sunrise")
  @Expose
  private int sunrise;
  @SerializedName("sunset")
  @Expose
  private int sunset;

  /**
   * Get country code (GB, JP etc.).
   * @return country code (GB, JP etc.)
   */
  public String getCountry() {
    return country;
  }

  /**
   * Set country code (GB, JP etc.).
   * @param country country code (GB, JP etc.)
   */
  public void setCountry(String country) {
    this.country = country;
  }

  /**
   * Get internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @return internal parameter
   */
  public int getId() {
    return id;
  }

  /**
   * Set internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @param id internal parameter
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @return internal parameter
   */
  public BigDecimal getMessage() {
    return message;
  }

  /**
   * Set internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @param message internal parameter
   */
  public void setMessage(BigDecimal message) {
    this.message = message;
  }

  /**
   * Get sunrise time, unix, UTC.
   * @return sunrise time, unix, UTC
   */
  public int getSunrise() {
    return sunrise;
  }

  /**
   * Set sunrise time, unix, UTC.
   * @param sunrise sunrise time, unix, UTC
   */
  public void setSunrise(int sunrise) {
    this.sunrise = sunrise;
  }

  /**
   * Get sunset time, unix, UTC.
   * @return sunset time, unix, UTC
   */
  public int getSunset() {
    return sunset;
  }

  /**
   * Set sunset time, unix, UTC.
   * @param sunset sunset time, unix, UTC
   */
  public void setSunset(int sunset) {
    this.sunset = sunset;
  }

  /**
   * Get internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @return internal parameter
   */
  public int getType() {
    return type;
  }

  /**
   * Set internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @param type internal parameter
   */
  public void setType(int type) {
    this.type = type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(country, id, message, sunrise, sunset, type);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Sys other = (Sys) obj;
    return Objects.equals(country, other.country) && id == other.id
        && Objects.equals(message, other.message) && sunrise == other.sunrise
        && sunset == other.sunset && type == other.type;
  }

  @Override
  public String toString() {
    return String.format("Sys [type=%s, id=%s, message=%s, country=%s, sunrise=%s, sunset=%s]",
        type, id, message, country, sunrise, sunset);
  }

  /**
   * Set country code (GB, JP etc.).
   * @param country country code (GB, JP etc.)
   */
  public Sys withCountry(String country) {
    this.country = country;
    return this;
  }

  /**
   * Set internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @param id internal parameter
   */
  public Sys withId(int id) {
    this.id = id;
    return this;
  }

  /**
   * Set internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @param message internal parameter
   */
  public Sys withMessage(BigDecimal message) {
    this.message = message;
    return this;
  }

  /**
   * Set sunrise time, unix, UTC.
   * @param sunrise sunrise time, unix, UTC
   */
  public Sys withSunrise(int sunrise) {
    this.sunrise = sunrise;
    return this;
  }

  /**
   * Set sunset time, unix, UTC.
   * @param sunset sunset time, unix, UTC
   */
  public Sys withSunset(int sunset) {
    this.sunset = sunset;
    return this;
  }

  /**
   * Set internal openweather parameter.
   * More details: https://openweathermap.org/current#current_JSON.
   * @param type internal parameter
   */
  public Sys withType(int type) {
    this.type = type;
    return this;
  }

}
