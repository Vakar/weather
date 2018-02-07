package space.vakar.weather.domain.model.atmosphere;

import java.io.Serializable;
import java.util.Objects;

public class Humidity  implements Serializable{

	private int id;
	private double value;
	private String unit;

	public Humidity() {
		setId(0);
		setValue(0);
		setUnit("");
	}

	public Humidity(double value, String unit) {
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
		if (object instanceof Humidity) {
			Humidity that = (Humidity) object;
			return this.id == that.id && this.value == that.value && Objects.equals(this.unit, that.unit);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Humidity [id=%s, value=%s, unit=%s]";
		return String.format(format, id, value, unit);
	}	
}
