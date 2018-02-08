package space.vakar.weather.domain.model;

import java.io.Serializable;

public class DomainObject implements Serializable{
	
	protected int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}	

	@Override
	public String toString() {
		String format = "DomainObject [id=%s]";
		return String.format(format, id);
	}	
}
