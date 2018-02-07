package space.vakar.weather.openweather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Pressure {
	
	/** Pressure value */
	private double value;
	
	/** hPa */
	private String unit;

	public Pressure() {
		
	}

	public Pressure(double value, String unit) {
		this.value = value;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(double value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	@XmlAttribute
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, unit);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Pressure) {
			Pressure that = (Pressure) object;
			return this.value == that.value 
					&& Objects.equals(this.unit, that.unit);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Pressure [value=%s, unit=%s]";
		return String.format(format, value, unit);
	}
}
