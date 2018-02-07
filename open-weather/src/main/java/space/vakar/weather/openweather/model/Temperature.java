package space.vakar.weather.openweather.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import space.vakar.weather.domain.model.temperature.TemperatureUnit;
import space.vakar.weather.openweather.util.TemperatureUnitAdapter;

public class Temperature {
	
	/** Temperature */
	private double value;
	
	/** Minimum temperature at the moment of calculation. This is deviation from 'temp' that is possible for large cities and megalopolises geographically expanded (use these parameter optionally). */
	private double min;
	
	/** Maximum temperature at the moment of calculation. This is deviation from 'temp' that is possible for large cities and megalopolises geographically expanded (use these parameter optionally). */
	private double max;
	
	/** Unit of measurements. Possilbe valure is Celsius, Kelvin, Fahrenheit. */
	private TemperatureUnit unit;

	public Temperature() {
		
	}

	public Temperature(double value, double min, double max, TemperatureUnit unit) {
		this.value = value;
		this.min = min;
		this.max = max;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(double value) {
		this.value = value;
	}

	public double getMin() {
		return min;
	}

	@XmlAttribute
	public void setMin(double min) {
		this.min = min;
	}

	public double getMax() {
		return max;
	}

	@XmlAttribute
	public void setMax(double max) {
		this.max = max;
	}

	public TemperatureUnit getUnit() {
		return unit;
	}

	@XmlAttribute
	@XmlJavaTypeAdapter(TemperatureUnitAdapter.class)
	public void setUnit(TemperatureUnit unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, min, max, unit);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Temperature) {
			Temperature that = (Temperature) object;
			return this.value == that.value 
					&& this.min == that.min 
					&& this.max == that.max
					&& Objects.equals(this.unit, that.unit);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Temperature [value=%s, min=%s, max=%s, unit=%s]";
		return String.format(format, value, min, max, unit);
	}	
}