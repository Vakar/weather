package space.vakar.weather.domain.model.location;

import java.util.Objects;

public class Location {

	private int id;
	private Coordinates coordinates;
	private Sun sun;
	private City city;
	private String country;
	
	public Location() {
		setId(0);
		setCoordinates(new Coordinates());
		setSun(new Sun());
		setCity(new City());
		setCountry("");
	}

	public Location(int id, Coordinates coordinates, Sun sun, City city,
			String country) {
		setId(id);
		setCoordinates(coordinates);
		setSun(sun);
		setCity(city);
		setCountry(country);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}

	public Sun getSun() {
		return sun;
	}

	public void setSun(Sun sun) {
		this.sun = sun;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, coordinates, sun, city, country);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Location) {
			Location that = (Location) object;
			return this.id == that.id && Objects.equals(this.coordinates, that.coordinates)
					&& Objects.equals(this.sun, that.sun)
					&& Objects.equals(this.city, that.city)
					&& Objects.equals(this.country, that.country);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Location [id=%s, coord=%s, sun=%s, city=%s, country=%s]";
		return String.format(format, id, coordinates, sun, city, country);
	}
}
