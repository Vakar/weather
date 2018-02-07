package space.vakar.weather.domain.model.location;

import java.io.Serializable;
import java.util.Objects;

public class Coordinates  implements Serializable{

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
	public boolean equals(Object object) {
		if (object instanceof Coordinates) {
			Coordinates that = (Coordinates) object;
			return this.id == that.id && this.longitude == that.longitude && this.latitude == that.latitude;
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Coordinates [id=%s, longitude=%s, latitude=%s]";
		return String.format(format, id, longitude, latitude);
	}
}