package space.vakar.weather.domain.model.wind;

import java.util.Objects;

import space.vakar.weather.domain.api.Defaultable;
import space.vakar.weather.domain.model.DomainObject;

public class Wind  extends DomainObject implements Defaultable<Wind>{
	
	private WindSpeed speed;
	private WindDirection direction;

	public Wind() {

	}
	
	public Wind(WindSpeed speed, WindDirection direction) {
		setSpeed(speed);
		setDirection(direction);
	}
	
	public Wind defaultInstance() {
		setId(0);
		setSpeed(new WindSpeed().defaultInstance());
		setDirection(new WindDirection().defaultInstance());
		return this;
	}

	public WindSpeed getSpeed() {
		return speed;
	}

	public void setSpeed(WindSpeed speed) {
		this.speed = speed;
	}

	public WindDirection getDirection() {
		return direction;
	}

	public void setDirection(WindDirection direction) {
		this.direction = direction;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, speed, direction);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Wind) {
			Wind that = (Wind) object;
			return this.id == that.id && Objects.equals(this.speed, that.speed)
					&& Objects.equals(this.direction, that.direction);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "Wind [id=%s, speed=%s, direction=%s]";
		return String.format(format, id, speed, direction);
	}	
}