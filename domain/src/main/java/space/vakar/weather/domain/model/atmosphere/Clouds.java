package space.vakar.weather.domain.model.atmosphere;

import java.util.Objects;

public class Clouds {

	private double value;

	private String name;

	public Clouds() {
		
	}

	public Clouds(double value, String name) {
		this.value = value;
		this.name = name;
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
		return Objects.hash(value, name);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Clouds) {
			Clouds that = (Clouds) object;
			return this.value == that.value 
					&& Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Clouds [value=%s, name=%s]";
		return String.format(format, value, name);
	}
}