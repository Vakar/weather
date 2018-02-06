package space.vakar.weather.openweather.model;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement
public class Sun {
	
	/** Sunrise time */
	private LocalDateTime rise;
	
	/** Sunset time */
	private LocalDateTime set;

	public LocalDateTime getRise() {
		return rise;
	}

	@XmlAttribute
	public void setRise(LocalDateTime rise) {
		this.rise = rise;
	}

	public LocalDateTime getSet() {
		return set;
	}

	@XmlAttribute
	public void setSet(LocalDateTime set) {
		this.set = set;
	}

	@Override
	public int hashCode() {
		return Objects.hash(rise, set);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Sun) {
			Sun that = (Sun) object;
			return Objects.equals(this.rise, that.rise) 
					&& Objects.equals(this.set, that.set);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Sun [rise=%s, set=%s]";
		return String.format(format, rise, set);
	}
}
