package space.vakar.weather.domain;

import java.util.Objects;

public class Wind {

	private int id;
	private WindSpeed speed;
	private WindDirection direction;

	public Wind() {
		setId(0);
		setSpeed(new WindSpeed());
		setDirection(new WindDirection());
	}
	
	public Wind(WindSpeed speed, WindDirection direction) {
		this();
		setSpeed(speed);
		setDirection(direction);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	public boolean equals(Object obj) {
		if (obj instanceof Wind) {
			final Wind other = (Wind) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(speed, other.speed)
					&& Objects.equals(direction, other.direction);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String format = "Wind [id=%s, speed=%s, direction=%s]";
		return String.format(format, id, speed, direction);
	}	
}