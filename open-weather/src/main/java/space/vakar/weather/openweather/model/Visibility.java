package space.vakar.weather.openweather.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Visibility {
	
	/** Visibility, meter */
	private double value;

	public Visibility(double value) {
		super();
		this.value = value;
	}

	public double getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Visibility) {
			Visibility that = (Visibility) object;
			return this.value == that.value;
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Visibility [value=%s]";
		return String.format(format, value);
	}
}
