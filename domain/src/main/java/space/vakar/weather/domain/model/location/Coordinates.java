package space.vakar.weather.domain.model.location;

import java.util.Objects;

import space.vakar.weather.domain.api.Defaultable;
import space.vakar.weather.domain.model.DomainObject;

public class Coordinates  extends DomainObject implements Defaultable<Coordinates>{

	private double longitude;
	private double latitude;

	public Coordinates() {

	}

	public Coordinates(double longitude, double latitude) {
		setLongitude(longitude);
		setLatitude(latitude);
	}
	
	public Coordinates defaultInstance() {
		setId(0);
		setLongitude(Double.NaN);
		setLatitude(Double.NaN);
		return this;
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
			return this.id == that.id 
					&& Double.compare(this.longitude , that.longitude ) == 0
					&& Double.compare(this.latitude , that.latitude) == 0;
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Coordinates [id=%s, longitude=%s, latitude=%s]";
		return String.format(format, id, longitude, latitude);
	}
}
