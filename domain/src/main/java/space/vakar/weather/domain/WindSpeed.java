package space.vakar.weather.domain;

import java.util.Objects;

public class WindSpeed {

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
	public boolean equals(Object obj) {
		if (obj instanceof WindSpeed) {
			final WindSpeed other = (WindSpeed) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(value, other.value)
					&& Objects.equals(name, other.name);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String format = "WindSpeed [id=%s, value=%s, name=%s]";
		return String.format(format, id, value, name);
	}
}