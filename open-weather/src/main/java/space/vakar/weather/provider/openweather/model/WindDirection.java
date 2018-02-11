package space.vakar.weather.provider.openweather.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "direction")
public class WindDirection {
	
	/** Wind direction, degrees  */
	private double value;
	
	/** Code of the wind direction. Possible value is WSW, N, S etc */
	private String code;
	
	/** Full name of the wind direction. */
	private String name;

	public WindDirection() {
		
	}

	public WindDirection(double value, String code, String name) {
		this.value = value;
		this.code = code;
		this.name = name;
	}

	public double getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(double value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	@XmlAttribute
	public void setCode(String code) {
		this.code = code;
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
		return Objects.hash(value, code, name);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof WindDirection) {
			WindDirection that = (WindDirection) object;
			return this.value == that.value 
					&& Objects.equals(this.code, that.code)
					&& Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "WindDirection [value=%s, code=%s, name=%s]";
		return String.format(format, value, code, name);
	}
}
