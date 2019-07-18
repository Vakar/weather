
package org.open.weather.json.model;

import java.io.Serializable;
import java.util.Objects;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Weather implements Serializable {

	private final static long serialVersionUID = -4638808814367361437L;

	@SerializedName("id")
	@Expose
	private int id;
	@SerializedName("main")
	@Expose
	private String main;
	@SerializedName("description")
	@Expose
	private String description;
	@SerializedName("icon")
	@Expose
	private String icon;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weather other = (Weather) obj;
		return Objects.equals(description, other.description) && Objects.equals(icon, other.icon) && id == other.id
				&& Objects.equals(main, other.main);
	}

	public String getDescription() {
		return description;
	}

	public String getIcon() {
		return icon;
	}

	public int getId() {
		return id;
	}

	public String getMain() {
		return main;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, icon, id, main);
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setMain(String main) {
		this.main = main;
	}

	@Override
	public String toString() {
		return String.format("Weather [id=%s, main=%s, description=%s, icon=%s]", id, main, description, icon);
	}

	public Weather withDescription(String description) {
		this.description = description;
		return this;
	}

	public Weather withIcon(String icon) {
		this.icon = icon;
		return this;
	}

	public Weather withId(int id) {
		this.id = id;
		return this;
	}

	public Weather withMain(String main) {
		this.main = main;
		return this;
	}

}
