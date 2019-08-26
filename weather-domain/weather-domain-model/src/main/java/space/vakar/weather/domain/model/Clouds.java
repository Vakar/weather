
package space.vakar.weather.domain.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.Objects;



public class Clouds implements Serializable {

  private static final long serialVersionUID = 5626784545040934884L;

  @SerializedName("all")
  @Expose
  private int all;

  /**
   * Default constructor.
   */
  public Clouds() {}

  /**
   * Create {Clouds} object with given cloudiness in %.
   * @param all cloudiness, %
   */
  public Clouds(int all) {
    this.all = all;
  }

  /**
   * Get cloudiness, %.
   * 
   * @return cloudiness in %
   */
  public int getAll() {
    return all;
  }

  /**
   * Set cloudiness, %.
   * 
   * @param all cloudiness in %
   */
  public void setAll(int all) {
    this.all = all;
  }

  @Override
  public int hashCode() {
    return Objects.hash(all);
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
    Clouds other = (Clouds) obj;
    return all == other.all;
  }

  @Override
  public String toString() {
    return String.format("Clouds [all=%s]", all);
  }

}
