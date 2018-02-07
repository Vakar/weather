package space.vakar.weather.domain.model.location;

import java.io.Serializable;
import java.util.Objects;

public class City  implements Serializable{

	private int id;
	private String name;

	public City() {
		setId(0);
		setName("");
	}

	public City(String name, String country, Coordinates coordinates) {
		this();
		setName(name);
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

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof City) {
			City that = (City) object;
			return this.id == that.id 
					&& Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "City [id=%s, name=%s]";
		return String.format(format, id, name);
	}
}
