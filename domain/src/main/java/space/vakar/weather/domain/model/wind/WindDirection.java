package space.vakar.weather.domain.model.wind;

import java.io.Serializable;
import java.util.Objects;

public class WindDirection  implements Serializable{

	private int id;
	private double value;
	private String code;
	private String name;

	public WindDirection() {
		setId(0);
		setValue(0);
		setCode("");
		setName("");
	}
	
	public WindDirection(double value, String code, String name) {
		this();
		setValue(value);
		setCode(code);
		setName(name);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, value, code, name);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof WindDirection) {
			WindDirection that = (WindDirection) object;
			return this.id == that.id 
					&& Double.compare(this.value, that.value) == 0  
					&& Objects.equals(this.code, that.code)
					&& Objects.equals(this.name, that.name);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "WindDirection [id=%s, value=%s, code=%s, name=%s]";
		return String.format(format, id, value, code, name);
	}
}
