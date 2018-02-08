package space.vakar.weather.domain.model.temperature;

import java.util.Objects;

import space.vakar.weather.domain.model.DomainObject;

public class Temperature  extends DomainObject{

	private double value;
	private TemperatureUnit unit;

	public Temperature() {
		setUnit(TemperatureUnit.KELVIN);
	}

	public Temperature(double value, TemperatureUnit unit) {
		setValue(value);
		setUnit(unit);
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public TemperatureUnit getUnit() {
		return unit;
	}

	public void setUnit(TemperatureUnit unit) {
		this.unit = unit;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id, value, unit);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Temperature) {
			Temperature that = (Temperature) object;
			return this.id == that.id 
					&& Double.compare(this.value, that.value) == 0 
					&& Objects.equals(this.unit, that.unit);
		}
		return false;
	}
	
	@Override
	public String toString() {
		String format = "Temperature [id=%s, value=%s, unit=%s]";
		return String.format(format, id, value, unit);
	}
	
}
