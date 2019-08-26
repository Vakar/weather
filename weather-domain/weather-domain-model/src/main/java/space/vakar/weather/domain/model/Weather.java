
package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Objects;

public class Weather implements Serializable {

  private static final long serialVersionUID = -4638808814367361437L;

  @SerializedName("id")
  @Expose
  private int id;
  @SerializedName("main")
  @Expose
  private String main;
  @SerializedName("description")
  @Expose
  private String description;
  @SerializedName("icon")
  @Expose
  private String icon;

  /**
   * Get weather condition within the group.
   * @return weather condition within the group
   */
  public String getDescription() {
    return description;
  }

  /**
   * Set weather condition within the group.
   * @param description weather condition within the group
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * Get weather icon id.
   * @return weather icon id
   */
  public String getIcon() {
    return icon;
  }

  /**
   * Set weather icon id.
   * @param icon weather icon id
   */
  public void setIcon(String icon) {
    this.icon = icon;
  }

  /**
   * Get weather condition id.
   * @return weather condition id
   */
  public int getId() {
    return id;
  }

  /**
   * Set weather condition id.
   * @param id weather condition id
   */
  public void setId(int id) {
    this.id = id;
  }

  /**
   * Get group of weather parameters (Rain, Snow, Extreme etc.).
   * @return group of weather parameters (Rain, Snow, Extreme etc.)
   */
  public String getMain() {
    return main;
  }

  /**
   * Set group of weather parameters (Rain, Snow, Extreme etc.).
   * @param main group of weather parameters (Rain, Snow, Extreme etc.)
   */
  public void setMain(String main) {
    this.main = main;
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, icon, id, main);
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
    Weather other = (Weather) obj;
    return Objects.equals(description, other.description) && Objects.equals(icon, other.icon)
        && id == other.id && Objects.equals(main, other.main);
  }

  @Override
  public String toString() {
    return String.format("Weather [id=%s, main=%s, description=%s, icon=%s]", id, main, description,
        icon);
  }

  /**
   * Set weather condition within the group.
   * @param description weather condition within the group
   */
  public Weather withDescription(String description) {
    this.description = description;
    return this;
  }

  /**
   * Set weather icon id.
   * @param icon weather icon id
   */
  public Weather withIcon(String icon) {
    this.icon = icon;
    return this;
  }

  /**
   * Set weather condition id.
   * @param id weather condition id
   */
  public Weather withId(int id) {
    this.id = id;
    return this;
  }

  /**
   * Set group of weather parameters (Rain, Snow, Extreme etc.).
   * @param main group of weather parameters (Rain, Snow, Extreme etc.)
   */
  public Weather withMain(String main) {
    this.main = main;
    return this;
  }

}
