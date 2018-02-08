package space.vakar.weather.domain.model.atmosphere;

import java.io.Serializable;
import java.util.Objects;

public class Clouds implements Serializable{

	private int id;
	private double value;
	private String name;

	public Clouds() {
		setValue(0);
		setName("");
	}

	public Clouds(double value, String name) {
		setValue(value);
		setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value, name);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Clouds) {
			Clouds that = (Clouds) object;
			return this.id == that.id 
					&& Double.compare(this.value, that.value) == 0
					&& Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Clouds [id=%s, value=%s, name=%s]";
		return String.format(format, id, value, name);
	}
}