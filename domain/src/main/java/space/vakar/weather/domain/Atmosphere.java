package space.vakar.weather.domain;

public class Atmosphere {

	private int id;
	private Humidity humidity;
	private Pressure pressure;
	private double visibility;
	private Precipitation precipitation;
	private Sun sun;

	public Atmosphere() {
		setId(0);
		setHumidity(new Humidity());
		setPressure(new Pressure());
		setVisibility(0);
		setPrecipitation(new Precipitation());
		setSun(new Sun());
	}

	public Atmosphere(Humidity humidity, Pressure pressure, double visibility, Precipitation precipitation) {
		super();
		setHumidity(humidity);
		setPressure(pressure);
		setVisibility(visibility);
		setPrecipitation(precipitation);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Humidity getHumidity() {
		return humidity;
	}

	public void setHumidity(Humidity humidity) {
		this.humidity = humidity;
	}

	public Pressure getPressure() {
		return pressure;
	}

	public void setPressure(Pressure pressure) {
		this.pressure = pressure;
	}

	public double getVisibility() {
		return visibility;
	}

	public void setVisibility(double visibility) {
		this.visibility = visibility;
	}

	public Precipitation getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(Precipitation precipitation) {
		this.precipitation = precipitation;
	}

	public Sun getSun() {
		return sun;
	}

	public void setSun(Sun sun) {
		this.sun = sun;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((humidity == null) ? 0 : humidity.hashCode());
		result = prime * result + id;
		result = prime * result + ((precipitation == null) ? 0 : precipitation.hashCode());
		result = prime * result + ((pressure == null) ? 0 : pressure.hashCode());
		result = prime * result + ((sun == null) ? 0 : sun.hashCode());
		long temp;
		temp = Double.doubleToLongBits(visibility);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Atmosphere other = (Atmosphere) obj;
		if (humidity == null) {
			if (other.humidity != null)
				return false;
		} else if (!humidity.equals(other.humidity))
			return false;
		if (id != other.id)
			return false;
		if (precipitation == null) {
			if (other.precipitation != null)
				return false;
		} else if (!precipitation.equals(other.precipitation))
			return false;
		if (pressure == null) {
			if (other.pressure != null)
				return false;
		} else if (!pressure.equals(other.pressure))
			return false;
		if (sun == null) {
			if (other.sun != null)
				return false;
		} else if (!sun.equals(other.sun))
			return false;
		if (Double.doubleToLongBits(visibility) != Double.doubleToLongBits(other.visibility))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atmosphere [id=" + id + ", humidity=" + humidity + ", pressure=" + pressure + ", visibility="
				+ visibility + ", precipitation=" + precipitation + ", sun=" + sun + "]";
	}
}
