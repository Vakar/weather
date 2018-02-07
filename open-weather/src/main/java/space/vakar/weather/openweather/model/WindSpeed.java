package space.vakar.weather.openweather.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "speed")
public class WindSpeed {
	
	/** Wind speed, mps */
	private double value;
	
	/** Type of the wind */
	private String name;

	public WindSpeed() {
		
	}

	public WindSpeed(double value, String name) {
		this.value = value;
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, name);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof WindSpeed) {
			WindSpeed that = (WindSpeed) object;
			return this.value == that.value 
					&& Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "WindSpeed [value=%s, name=%s]";
		return String.format(format, value, name);
	}
}
