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
	public boolean equals(Object object) {
		if (object instanceof City) {
			City that = (City) object;
			return this.id == that.id && Objects.equals(this.name, that.name)
					&& Objects.equals(this.country, that.country) && Objects.equals(this.coordinates, that.coordinates);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "City [id=%s, name=%s, country=%s, coordinates=%s]";
		return String.format(format, id, name, country, coordinates);
	}

	
}
