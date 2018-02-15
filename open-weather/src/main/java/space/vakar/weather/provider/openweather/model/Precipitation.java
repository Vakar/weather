package space.vakar.weather.provider.openweather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Precipitation {
	
	/** Precipitation, mm */
	private double value;
	
	/** Possible values are 'no", name of */
	private String mode;
	
	private String unit;

	public Precipitation() {
		
	}

	public Precipitation(double value, String mode) {
		this.value = value;
		this.mode = mode;
	}

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

	public String getUnit() {
		return unit;
	}

	@XmlAttribute
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value, mode, unit);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Precipitation) {
			Precipitation that = (Precipitation) object;
			return this.value == that.value && Objects.equals(this.mode, that.mode)
					&& Objects.equals(this.unit, that.unit);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Precipitation [value=%s, mode=%s, unit=%s]";
		return String.format(format, value, mode, unit);
	}
}
