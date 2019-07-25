package space.vakar.weather.domain.model;

import java.io.Serializable;
import java.util.Objects;

public class City implements Serializable {

	private int id;
	private String name;
	private String country;

	public City() {
	}

	public City(int id, String name, String country) {
		this.id = id;
		this.name = name;
		this.country = country;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof City))
			return false;
		City that = (City) o;
		return id == that.id && Objects.equals(name, that.name) && Objects.equals(country, that.country);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, country);
	}

	@Override
	public String toString() {
		return "CityLocation{" + "id=" + id + ", name='" + name + '\'' + ", country='" + country + '\'' + '}';
	}
}