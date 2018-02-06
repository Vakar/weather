package space.vakar.weather.openweather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Precipitation {
	
	/** Precipitation, mm */
	private double value;
	
	/** Possible values are 'no", name of */
	private String mode;

	public double getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(double value) {
		this.value = value;
	}

	public String getMode() {
		return mode;
	}

	@XmlAttribute
	public void setMode(String mode) {
		this.mode = mode;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, mode);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Precipitation) {
			Precipitation that = (Precipitation) object;
			return this.value == that.value 
					&& Objects.equals(this.mode, that.mode);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Precipitation [value=%s, mode=%s]";
		return String.format(format, value, mode);
	}
}
