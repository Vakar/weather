package space.vakar.weather.domain.model.impl.wind;

import java.math.BigDecimal;
import java.util.Objects;
import space.vakar.weather.domain.model.impl.DomainObject;

public class WindDirection extends DomainObject {

	private BigDecimal value;
	private String code;
	private String name;

	public WindDirection() {

	}
	
	public WindDirection(BigDecimal value, String code, String name) {
		setValue(value);
		setCode(code);
		setName(name);
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
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
					&& Objects.equals(this.value, that.value)
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
