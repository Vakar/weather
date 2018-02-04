package space.vakar.weather.domain;

import java.util.Objects;

public class City {

	private int id;
	private String name;
	private String country;
	private Coordinates coordinates;

	public City() {
		setId(0);
		setName("");
		setCountry("");
		setCoordinates(new Coordinates());
	}

	public City(String name, String country, Coordinates coordinates) {
		this();
		setName(name);
		setCountry(country);
		setCoordinates(coordinates);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Coordinates getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, name, country, coordinates);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof City) {
			final City other = (City) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(name, other.name)
					&& Objects.equals(country, other.country)
					&& Objects.equals(coordinates, other.coordinates);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String format = "City [id=%s, name=%s, country=%s, coordinates=%s]";
		return String.format(format, id, name, country, coordinates);
	}

	
}
