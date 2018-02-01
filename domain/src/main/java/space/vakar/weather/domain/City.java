package space.vakar.weather.domain;

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

	public City(int id, String name, String country, Coordinates coordinates) {
		setId(id);
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coordinates == null) ? 0 : coordinates.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", country=" + country + ", coordinates=" + coordinates + "]";
	}
}
