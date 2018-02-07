package space.vakar.weather.domain;

import java.io.Serializable;
import java.util.Objects;

public class Precipitation  implements Serializable{

	private int id;
	private double value;
	private String mode;

	public Precipitation() {
		setId(id);
		setValue(value);
		setMode(mode);
	}

	public Precipitation(double value, String mode) {
		super();
		setValue(value);
		setMode(mode);
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

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, value, mode);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Precipitation) {
			Precipitation that = (Precipitation) object;
			return this.id == that.id && this.value == that.value && Objects.equals(this.mode, that.mode);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Precipitation [id=%s, value=%s, mode=%s]";
		return String.format(format, id, value, mode);
	}

	
}
