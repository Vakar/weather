package space.vakar.weather.domain;

public class Atmosphere {

	private int id;
	private Humidity humidity;
	private Pressure pressure;
	private int visibility;
	private double precipitation;
	private Sun sun;

	public Atmosphere() {
		setId(0);
		setHumidity(new Humidity());
		setPressure(new Pressure());
		setVisibility(0);
		setPrecipitation(0);
		setSun(new Sun());
	}

	public Atmosphere(Humidity humidity, Pressure pressure, int visibility, double precipitation) {
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

	public int getVisibility() {
		return visibility;
	}

	public void setVisibility(int visibility) {
		this.visibility = visibility;
	}

	public double getPrecipitation() {
		return precipitation;
	}

	public void setPrecipitation(double precipitation) {
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
		result = prime * result
				+ ((humidity == null) ? 0 : humidity.hashCode());
		result = prime * result + id;
		long temp;
		temp = Double.doubleToLongBits(precipitation);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result
				+ ((pressure == null) ? 0 : pressure.hashCode());
		result = prime * result + ((sun == null) ? 0 : sun.hashCode());
		result = prime * result + visibility;
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
		if (Double.doubleToLongBits(precipitation) != Double
				.doubleToLongBits(other.precipitation))
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
		if (visibility != other.visibility)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Atmosphere [id=").append(id).append(", humidity=")
				.append(humidity).append(", pressure=").append(pressure)
				.append(", visibility=").append(visibility)
				.append(", precipitation=").append(precipitation)
				.append(", sun=").append(sun).append("]");
		return builder.toString();
	}


}
