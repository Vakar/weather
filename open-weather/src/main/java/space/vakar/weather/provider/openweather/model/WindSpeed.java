package space.vakar.weather.provider.openweather.model;

import java.math.BigDecimal;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "speed")
public class WindSpeed {
	
	/** Wind speed, mps */
	private BigDecimal value;
	
	/** Type of the wind */
	private String name;

	public WindSpeed() {
		
	}

	public WindSpeed(BigDecimal value, String name) {
		this.value = value;
		this.name = name;
	}

	public BigDecimal getValue() {
		return value;
	}

	@XmlAttribute
	public void setValue(BigDecimal value) {
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
			return Objects.equals(this.value, that.value)
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
