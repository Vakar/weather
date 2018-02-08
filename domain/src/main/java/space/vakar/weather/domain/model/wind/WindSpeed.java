package space.vakar.weather.domain.model.wind;

import java.util.Objects;

import space.vakar.weather.domain.model.DomainObject;

public class WindSpeed  extends DomainObject{

	private double value;
	private String name;

	public WindSpeed() {
		setName("");
	}

	public WindSpeed(double value, String name) {
		setValue(value);
		setName(name);
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
			return this.id == that.id 
					&& Double.compare(this.value, that.value) == 0 
					&& Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "WindSpeed [id=%s, value=%s, name=%s]";
		return String.format(format, id, value, name);
	}
}