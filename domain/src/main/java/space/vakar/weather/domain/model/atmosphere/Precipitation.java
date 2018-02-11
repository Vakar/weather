package space.vakar.weather.domain.model.atmosphere;

import java.util.Objects;

import space.vakar.weather.domain.model.DomainObject;

public class Precipitation  extends DomainObject{

	private double value;
	private String mode;

	public Precipitation() {

	}

	public Precipitation(double value, String mode) {
		setValue(value);
		setMode(mode);
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
			return this.id == that.id 
					&& Double.compare(this.value , that.value ) == 0
					&& Objects.equals(this.mode, that.mode);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Precipitation [id=%s, value=%s, mode=%s]";
		return String.format(format, id, value, mode);
	}

	
}
