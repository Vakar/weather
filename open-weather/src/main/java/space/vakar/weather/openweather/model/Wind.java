package space.vakar.weather.openweather.model;

import java.util.Objects;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Wind {

	private WindSpeed speed;
	private WindDirection direction;

	public Wind(WindSpeed speed, WindDirection direction) {
		this.speed = speed;
		this.direction = direction;
	}

	public WindSpeed getSpeed() {
		return speed;
	}

	@XmlElement
	public void setSpeed(WindSpeed speed) {
		this.speed = speed;
	}

	public WindDirection getDirection() {
		return direction;
	}

	@XmlElement
	public void setDirection(WindDirection direction) {
		this.direction = direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(speed, direction);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Wind) {
			Wind that = (Wind) object;
			return Objects.equals(this.speed, that.speed) 
					&& Objects.equals(this.direction, that.direction);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Wind [speed=%s, direction=%s]";
		return String.format(format, speed, direction);
	}
}
