package space.vakar.weather.domain.model.atmosphere;

import java.util.Objects;

import space.vakar.weather.domain.model.DomainObject;

public class Pressure  extends DomainObject{

	private double value;
	private String unit;

	public Pressure() {

	}

	public Pressure(double value, String unit) {
		setValue(value);
		setUnit(unit);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value, unit);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Pressure) {
			Pressure that = (Pressure) object;
			return this.id == that.id 
					&& Double.compare(this.value , that.value) == 0 
					&& Objects.equals(this.unit, that.unit);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Pressure [id=%s, value=%s, unit=%s]";
		return String.format(format, id, value, unit);
	}
}
