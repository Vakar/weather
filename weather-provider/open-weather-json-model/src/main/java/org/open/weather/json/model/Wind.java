
package org.open.weather.json.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Wind implements Serializable {

	private final static long serialVersionUID = 2769601011851779264L;

	@SerializedName("speed")
	@Expose
	private BigDecimal speed;
	@SerializedName("gust")
	@Expose
	private BigDecimal gust;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wind other = (Wind) obj;
		return Objects.equals(gust, other.gust) && Objects.equals(speed, other.speed);
	}

	public BigDecimal getGust() {
		return gust;
	}

	public BigDecimal getSpeed() {
		return speed;
	}

	@Override
	public int hashCode() {
		return Objects.hash(gust, speed);
	}

	public void setGust(BigDecimal gust) {
		this.gust = gust;
	}

	public void setSpeed(BigDecimal speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return String.format("Wind [speed=%s, gust=%s]", speed, gust);
	}

	public Wind withGust(BigDecimal gust) {
		this.gust = gust;
		return this;
	}

	public Wind withSpeed(BigDecimal speed) {
		this.speed = speed;
		return this;
	}

}
