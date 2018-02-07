package space.vakar.weather.domain;

import java.io.Serializable;
import java.util.Objects;

public class WindSpeed  implements Serializable{

	private int id;
	private double value;
	private String name;

	public WindSpeed() {
		setId(0);
		setValue(0);
		setName("");
	}

	public WindSpeed(double value, String name) {
		this();
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
		if (object instanceof WindSpeed) {
			WindSpeed that = (WindSpeed) object;
			return this.id == that.id && this.value == that.value && Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "WindSpeed [id=%s, value=%s, name=%s]";
		return String.format(format, id, value, name);
	}
}