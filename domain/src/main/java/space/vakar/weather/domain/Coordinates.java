package space.vakar.weather.domain;

import java.util.Objects;

public class Coordinates {

	private int id;
	private double longitude;
	private double latitude;

	public Coordinates() {
		setId(0);
		setLongitude(0);
		setLatitude(0);
	}

	public Coordinates(double longitude, double latitude) {
		this();
		setLongitude(longitude);
		setLatitude(latitude);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, longitude, latitude);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Coordinates) {
			final Coordinates other = (Coordinates) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(longitude, other.longitude)
					&& Objects.equals(latitude, other.latitude);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String format = "Coordinates [id=%s, longitude=%s, latitude=%s]";
		return String.format(format, id, longitude, latitude);
	}
}
