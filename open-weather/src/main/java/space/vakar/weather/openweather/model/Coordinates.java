package space.vakar.weather.openweather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Coordinates {
	
	/** Geographical location, longitude */
	private double longitude;
	
	/** Geographical location, latitude */
	private double latitude;

	public Coordinates() {
		
	}

	public Coordinates(double longitude, double latitude) {
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@XmlAttribute(name="lon")
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	@XmlAttribute(name="lat")
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	@Override
	public int hashCode() {
		return Objects.hash(longitude, latitude);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Coordinates) {
			Coordinates that = (Coordinates) object;
			return this.longitude == that.longitude 
					&& this.latitude == that.latitude;
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Coordinates [longitude=%s, latitude=%s]";
		return String.format(format, longitude, latitude);
	}
}
