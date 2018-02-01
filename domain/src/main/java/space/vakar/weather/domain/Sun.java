package space.vakar.weather.domain;

import java.time.LocalDateTime;

public class Sun {

	private int id;
	private LocalDateTime rise;
	private LocalDateTime set;

	public Sun() {
		setId(0);
		setRise(LocalDateTime.MIN);
		setSet(LocalDateTime.MIN);
	}

	public Sun(int id, LocalDateTime rise, LocalDateTime set) {
		setId(id);
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
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rise == null) ? 0 : rise.hashCode());
		result = prime * result + ((set == null) ? 0 : set.hashCode());
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
		Sun other = (Sun) obj;
		if (rise == null) {
			if (other.rise != null)
				return false;
		} else if (!rise.equals(other.rise))
			return false;
		if (set == null) {
			if (other.set != null)
				return false;
		} else if (!set.equals(other.set))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sun [rise=" + rise + ", set=" + set + "]";
	}
}
