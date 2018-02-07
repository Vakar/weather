package space.vakar.weather.openweather.model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import space.vakar.weather.openweather.util.LocalDateTimeAdapter;

import java.util.Objects;

@XmlRootElement(name = "lastupdate")
public class LastUpdate {
	
	/** Last time when data was updated */
	private LocalDateTime value;

	public LastUpdate() {
		
	}

	public LastUpdate(LocalDateTime value) {
		this.value = value;
	}

	public LocalDateTime getValue() {
		return value;
	}

	@XmlAttribute
	@XmlJavaTypeAdapter(LocalDateTimeAdapter.class)
	public void setValue(LocalDateTime value) {
		this.value = value;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(value);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof LastUpdate) {
			LastUpdate that = (LastUpdate) object;
			return Objects.equals(this.value, that.value);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "LastUpdate [value=%s]";
		return String.format(format, value);
	}
}
