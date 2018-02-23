package space.vakar.weather.domain.model.impl.location;

import java.math.BigDecimal;
import java.util.Objects;
import space.vakar.weather.domain.model.api.Defaultable;
import space.vakar.weather.domain.model.impl.DomainObject;

public class Coordinates  extends DomainObject implements Defaultable<Coordinates>{

	private BigDecimal longitude;
	private BigDecimal latitude;

	public Coordinates() {

	}

	public Coordinates(BigDecimal longitude, BigDecimal latitude) {
		setLongitude(longitude);
		setLatitude(latitude);
	}
	
	public Coordinates defaultInstance() {
		setId(0);
		setLongitude(new BigDecimal(-1.0));
		setLatitude(new BigDecimal(-1.0));
		return this;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
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
					&& Objects.equals(this.longitude, that.longitude)
					&& Objects.equals(this.latitude, that.latitude);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Coordinates [id=%s, longitude=%s, latitude=%s]";
		return String.format(format, id, longitude, latitude);
	}
}