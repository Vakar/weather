
package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class WeatherDto implements Serializable {

  private static final long serialVersionUID = 2946557401046761713L;

  @SerializedName("coord")
  @Expose
  private Coord coord;
  @SerializedName("weather")
  @Expose
  private List<Weather> weather = null;
  @SerializedName("base")
  @Expose
  private String base;
  @SerializedName("main")
  @Expose
  private Main main;
  @SerializedName("visibility")
  @Expose
  private int visibility;
  @SerializedName("wind")
  @Expose
  private Wind wind;
  @SerializedName("clouds")
  @Expose
  private Clouds clouds;
  @SerializedName("dt")
  @Expose
  private long dt;
  @SerializedName("sys")
  @Expose
  private Sys sys;
  @SerializedName("timezone")
  @Expose
  private int timezone;
  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("name")
  @Expose
  private String name;
  @SerializedName("cod")
  @Expose
  private int cod;

  /**
   * Get base internal parameter.
   * @return base internal parameter
   */
  public String getBase() {
    return base;
  }

  /**
   * Set base internal parameter.
   * @param base base internal parameter
   */
  public void setBase(String base) {
    this.base = base;
  }

  /**
   * Get clouds.
   * @return clouds
   */
  public Clouds getClouds() {
    return clouds;
  }

  /**
   * Set clouds in % from 0 to 100.
   * @param clouds clouds in %
   */
  public void setClouds(Clouds clouds) {
    this.clouds = clouds;
  }

  /**
   * Get HTTP response code.
   * @return HTTP response code
   */
  public int getCod() {
    return cod;
  }

  /**
   * Set HTTP response code.
   * @param cod HTTP response code
   */
  public void setCod(int cod) {
    this.cod = cod;
  }

  /**
   * Get coordinates.
   * @return coordinates
   */
  public Coord getCoord() {
    return coord;
  }

  /**
   * Set coordinates.
   * @param coord coordinates
   */
  public void setCoord(Coord coord) {
    this.coord = coord;
  }

  /**
   * Get time of data calculation, unix, UTC.
   * @return time of data calculation, unix, UTC
   */
  public long getDt() {
    return dt;
  }

  /**
   * Set time of data calculation, unix, UTC.
   * @param dt time of data calculation, unix, UTC
   */
  public void setDt(long dt) {
    this.dt = dt;
  }

  /**
   * Get city ID.
   * @return city ID
   */
  public int getId() {
    return id;
  }

  /**
   * Set city ID.
   * @param id city ID
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get main weather data.
   * @return main weather data
   */
  public Main getMain() {
    return main;
  }

  /**
   * Set main weather data.
   * @param main main weather data
   */
  public void setMain(Main main) {
    this.main = main;
  }

  /**
   * Get city name.
   * @return city name
   */
  public String getName() {
    return name;
  }

  /**
   * Set city name.
   * @param name city name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Get system data.
   * @return system data
   */
  public Sys getSys() {
    return sys;
  }

  /**
   * Set system data.
   * @param sys system data
   */
  public void setSys(Sys sys) {
    this.sys = sys;
  }

  /**
   * Get shift in seconds from UTC.
   * @return shift in seconds from UTC
   */
  public int getTimezone() {
    return timezone;
  }

  /**
   * Set shift in seconds from UTC.
   * @param timezone shift in seconds from UTC
   */
  public void setTimezone(int timezone) {
    this.timezone = timezone;
  }

  /**
   * Get visibility.
   * @return visibility in meters
   */
  public int getVisibility() {
    return visibility;
  }

  /**
   * Set visibility.
   * @param visibility visibility in meters
   */
  public void setVisibility(int visibility) {
    this.visibility = visibility;
  }

  /**
   * Get weather list.
   * @return weather list
   */
  public List<Weather> getWeather() {
    return weather;
  }

  /**
   * Set weather list.
   * @param weather weather list
   */
  public void setWeather(List<Weather> weather) {
    this.weather = weather;
  }

  /**
   * Get wind.
   * @return wind
   */
  public Wind getWind() {
    return wind;
  }

  /**
   * Set wind.
   * @param wind wind
   */
  public void setWind(Wind wind) {
    this.wind = wind;
  }

  @Override
  public int hashCode() {
    return Objects.hash(base, clouds, cod, coord, dt, id, main, name, sys, timezone, visibility,
        weather, wind);
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
    WeatherDto other = (WeatherDto) obj;
    return Objects.equals(base, other.base) && Objects.equals(clouds, other.clouds)
        && cod == other.cod && Objects.equals(coord, other.coord) && dt == other.dt
        && id == other.id && Objects.equals(main, other.main) && Objects.equals(name, other.name)
        && Objects.equals(sys, other.sys) && timezone == other.timezone
        && visibility == other.visibility && Objects.equals(weather, other.weather)
        && Objects.equals(wind, other.wind);
  }

  @Override
  public String toString() {
    return String.format(
        "WeatherDTO [coord=%s, weather=%s, base=%s, main=%s, visibility=%s, "
            + "wind=%s, clouds=%s, dt=%s, sys=%s, timezone=%s, id=%s, name=%s, cod=%s]",
        coord, weather, base, main, visibility, wind, clouds, dt, sys, timezone, id, name, cod);
  }

  /**
   * Set base internal parameter.
   * @param base base internal parameter
   */
  public WeatherDto withBase(String base) {
    this.base = base;
    return this;
  }

  /**
   * Set clouds.
   * @param clouds clouds
   */
  public WeatherDto withClouds(Clouds clouds) {
    this.clouds = clouds;
    return this;
  }

  /**
   * Set HTTP response code.
   * @param cod HTTP response code
   */
  public WeatherDto withCod(int cod) {
    this.cod = cod;
    return this;
  }

  /**
   * Set coordinates.
   * @param coord coordinates
   */
  public WeatherDto withCoord(Coord coord) {
    this.coord = coord;
    return this;
  }

  /**
   * Set time of data calculation, unix, UTC.
   * @param dt time of data calculation, unix, UTC
   */
  public WeatherDto withDt(int dt) {
    this.dt = dt;
    return this;
  }

  /**
   * Set city ID.
   * @param id city ID
   */
  public WeatherDto withId(int id) {
    this.id = id;
    return this;
  }

  /**
   * Set main weather data.
   * @param main main weather data
   */
  public WeatherDto withMain(Main main) {
    this.main = main;
    return this;
  }

  /**
   * Set city name.
   * @param name city name
   */
  public WeatherDto withName(String name) {
    this.name = name;
    return this;
  }

  /**
   * Set system data.
   * @param sys system data
   */
  public WeatherDto withSys(Sys sys) {
    this.sys = sys;
    return this;
  }

  /**
   * Set shift in seconds from UTC.
   * @param timezone shift in seconds from UTC
   */
  public WeatherDto withTimezone(int timezone) {
    this.timezone = timezone;
    return this;
  }

  /**
   * Set visibility.
   * @param visibility visibility in meters
   */
  public WeatherDto withVisibility(int visibility) {
    this.visibility = visibility;
    return this;
  }

  /**
   * Set weather list.
   * @param weather weather list
   */
  public WeatherDto withWeather(List<Weather> weather) {
    this.weather = weather;
    return this;
  }

  /**
   * Set wind.
   * @param wind wind
   */
  public WeatherDto withWind(Wind wind) {
    this.wind = wind;
    return this;
  }

}
