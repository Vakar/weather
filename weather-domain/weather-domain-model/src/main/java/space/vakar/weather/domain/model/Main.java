
package space.vakar.weather.domain.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Main implements Serializable {

	private final static long serialVersionUID = 6029719905243037484L;

	@SerializedName("temp")
	@Expose
	private BigDecimal temp;
	@SerializedName("pressure")
	@Expose
	private int pressure;
	@SerializedName("humidity")
	@Expose
	private int humidity;
	@SerializedName("temp_min")
	@Expose
	private BigDecimal tempMin;
	@SerializedName("temp_max")
	@Expose
	private BigDecimal tempMax;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Main other = (Main) obj;
		return humidity == other.humidity && pressure == other.pressure && Objects.equals(temp, other.temp)
				&& Objects.equals(tempMax, other.tempMax) && Objects.equals(tempMin, other.tempMin);
	}

	public int getHumidity() {
		return humidity;
	}

	public int getPressure() {
		return pressure;
	}

	public BigDecimal getTemp() {
		return temp;
	}

	public BigDecimal getTempMax() {
		return tempMax;
	}

	public BigDecimal getTempMin() {
		return tempMin;
	}

	@Override
	public int hashCode() {
		return Objects.hash(humidity, pressure, temp, tempMax, tempMin);
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public void setPressure(int pressure) {
		this.pressure = pressure;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public void setTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
	}

	public void setTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
	}

	@Override
	public String toString() {
		return String.format("Main [temp=%s, pressure=%s, humidity=%s, tempMin=%s, tempMax=%s]", temp, pressure,
				humidity, tempMin, tempMax);
	}

	public Main withHumidity(int humidity) {
		this.humidity = humidity;
		return this;
	}

	public Main withPressure(int pressure) {
		this.pressure = pressure;
		return this;
	}

	public Main withTemp(BigDecimal temp) {
		this.temp = temp;
		return this;
	}

	public Main withTempMax(BigDecimal tempMax) {
		this.tempMax = tempMax;
		return this;
	}

	public Main withTempMin(BigDecimal tempMin) {
		this.tempMin = tempMin;
		return this;
	}

}
