package space.vakar.weather.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class Sun {

	private int id;
	private LocalDateTime rise;
	private LocalDateTime set;

	public Sun() {
		setId(0);
		setRise(LocalDateTime.MIN);
		setSet(LocalDateTime.MIN);
	}

	public Sun(LocalDateTime rise, LocalDateTime set) {
		this();
		setRise(rise);
		setSet(set);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getRise() {
		return rise;
	}

	public void setRise(LocalDateTime rise) {
		this.rise = rise;
	}

	public LocalDateTime getSet() {
		return set;
	}

	public void setSet(LocalDateTime set) {
		this.set = set;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, rise, set);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Sun) {
			final Sun other = (Sun) obj;
			return Objects.equals(id, other.id)
					&& Objects.equals(rise, other.rise)
					&& Objects.equals(set, other.set);
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		String format = "Sun [id=%s, rise=%s, set=%s]";
		return String.format(format, id, rise, set);
	}	
}
