package space.vakar.weather.domain;

public class Wind {

	private int id;
	private WindSpeed windSpeed;
	private WindDirection windDirection;

	public Wind() {
		setId(0);
		setWindSpeed(new WindSpeed());
		setWindDirection(new WindDirection());
	}
	
	public Wind(WindSpeed windSpeed, WindDirection windDirection) {
		super();
		setWindSpeed(windSpeed);
		setWindDirection(windDirection);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WindSpeed getWindSpeed() {
		return windSpeed;
	}

	public void setWindSpeed(WindSpeed windSpeed) {
		this.windSpeed = windSpeed;
	}

	public WindDirection getWindDirection() {
		return windDirection;
	}

	public void setWindDirection(WindDirection windDirection) {
		this.windDirection = windDirection;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((windDirection == null) ? 0 : windDirection.hashCode());
		result = prime * result + ((windSpeed == null) ? 0 : windSpeed.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wind other = (Wind) obj;
		if (id != other.id)
			return false;
		if (windDirection == null) {
			if (other.windDirection != null)
				return false;
		} else if (!windDirection.equals(other.windDirection))
			return false;
		if (windSpeed == null) {
			if (other.windSpeed != null)
				return false;
		} else if (!windSpeed.equals(other.windSpeed))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Wind [id=" + id + ", windSpeed=" + windSpeed + ", windDirection=" + windDirection + "]";
	}
}
