package space.vakar.weather.domain.model;

import java.io.Serializable;
import java.util.Objects;

public class DomainObject implements Serializable{
	
	private int id;
	
	public DomainObject() {
		
	}

	public DomainObject(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(id);
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof DomainObject) {
			DomainObject that = (DomainObject) object;
			return this.id == that.id;
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "DomainObject [id=%s]";
		return String.format(format, id);
	}
}
