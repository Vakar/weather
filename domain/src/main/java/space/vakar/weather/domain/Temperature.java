package space.vakar.weather.domain;

import java.util.Objects;

public class Temperature {

	private int id;
	private double value;
	private TemperatureUnit unit;

	public Temperature() {
		setId(0);
		setValue(0);
		setUnit(TemperatureUnit.KELVIN);
	}

	public Temperature(double value, TemperatureUnit unit) {
		this();
		setValue(value);
		setUnit(unit);
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
	public boolean equals(Object obj) {
		if (obj instanceof Temperature) {
			final Temperature other = (Temperature) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(value, other.value)
					&& Objects.equals(unit, other.unit);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String format = "Temperature [id=%s, value=%s, unit=%s]";
		return String.format(format, id, value, unit);
	}
	
}
