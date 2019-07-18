
package org.open.weather.json.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Coord implements Serializable {

	private final static long serialVersionUID = -2824663640738017828L;

	@SerializedName("lon")
	@Expose
	private BigDecimal lon;
	@SerializedName("lat")
	@Expose
	private BigDecimal lat;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coord other = (Coord) obj;
		return Objects.equals(lat, other.lat) && Objects.equals(lon, other.lon);
	}

	public BigDecimal getLat() {
		return lat;
	}

	public BigDecimal getLon() {
		return lon;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lat, lon);
	}

	public void setLat(BigDecimal lat) {
		this.lat = lat;
	}

	public void setLon(BigDecimal lon) {
		this.lon = lon;
	}

	@Override
	public String toString() {
		return String.format("Coord [lon=%s, lat=%s]", lon, lat);
	}

	public Coord withLat(BigDecimal lat) {
		this.lat = lat;
		return this;
	}

	public Coord withLon(BigDecimal lon) {
		this.lon = lon;
		return this;
	}

}
