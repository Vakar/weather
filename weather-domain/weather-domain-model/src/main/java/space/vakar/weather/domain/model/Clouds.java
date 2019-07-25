
package space.vakar.weather.domain.model;

import java.io.Serializable;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clouds implements Serializable {

	private final static long serialVersionUID = 5626784545040934884L;

	@SerializedName("all")
	@Expose
	private int all;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clouds other = (Clouds) obj;
		return all == other.all;
	}

	public int getAll() {
		return all;
	}

	@Override
	public int hashCode() {
		return Objects.hash(all);
	}

	public void setAll(int all) {
		this.all = all;
	}

	@Override
	public String toString() {
		return String.format("Clouds [all=%s]", all);
	}

	public Clouds withAll(int all) {
		this.all = all;
		return this;
	}

}
