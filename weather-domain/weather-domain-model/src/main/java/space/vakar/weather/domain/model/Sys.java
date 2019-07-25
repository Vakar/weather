
package space.vakar.weather.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys implements Serializable {

	private final static long serialVersionUID = -6633630464954791315L;

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

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sys other = (Sys) obj;
		return Objects.equals(country, other.country) && id == other.id && Objects.equals(message, other.message)
				&& sunrise == other.sunrise && sunset == other.sunset && type == other.type;
	}

	public String getCountry() {
		return country;
	}

	public int getId() {
		return id;
	}

	public BigDecimal getMessage() {
		return message;
	}

	public int getSunrise() {
		return sunrise;
	}

	public int getSunset() {
		return sunset;
	}

	public int getType() {
		return type;
	}

	@Override
	public int hashCode() {
		return Objects.hash(country, id, message, sunrise, sunset, type);
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMessage(BigDecimal message) {
		this.message = message;
	}

	public void setSunrise(int sunrise) {
		this.sunrise = sunrise;
	}

	public void setSunset(int sunset) {
		this.sunset = sunset;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("Sys [type=%s, id=%s, message=%s, country=%s, sunrise=%s, sunset=%s]", type, id, message,
				country, sunrise, sunset);
	}

	public Sys withCountry(String country) {
		this.country = country;
		return this;
	}

	public Sys withId(int id) {
		this.id = id;
		return this;
	}

	public Sys withMessage(BigDecimal message) {
		this.message = message;
		return this;
	}

	public Sys withSunrise(int sunrise) {
		this.sunrise = sunrise;
		return this;
	}

	public Sys withSunset(int sunset) {
		this.sunset = sunset;
		return this;
	}

	public Sys withType(int type) {
		this.type = type;
		return this;
	}

}
