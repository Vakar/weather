package space.vakar.weather.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.WeatherContainer;

public class Container implements WeatherContainer {

	private Deque<Node> stack = new ArrayDeque<>();

	@Override
	public void push(Weather weather, int cityId) {
		stack.addFirst(new Node(weather, cityId, LocalDateTime.now()));
	}

	@Override
	public Weather pull(int cityId) {
		Weather weather = findWeatherByCityId(cityId);
		return weather == null ? null : weather;
	}

	@Override
	public boolean isExist(int cityId) {
		return findWeatherByCityId(cityId) == null ? false : true;
	}

	private Weather findWeatherByCityId(int cityId) {
		Weather weather = null;
		for (Node node : stack) {
			if (node.getCityId() == cityId) {
				weather = node.getWeather();
				break;
			}
		}
		return weather;
	}

	@Override
	public boolean isFresh(int cityId) {
		// TODO Auto-generated method stub
		return false;
	}

	public Deque<Node> getStack() {
		return stack;
	}

	public void setStack(Deque<Node> stack) {
		this.stack = stack;
	}

	class Node {
		private Weather weather;
		private int cityId;
		private LocalDateTime updateTime;

		public Node(Weather weather, int cityId, LocalDateTime updateTime) {
			this.weather = weather;
			this.cityId = cityId;
			this.updateTime = updateTime;
		}

		public Weather getWeather() {
			return weather;
		}

		public void setWeather(Weather weather) {
			this.weather = weather;
		}

		public int getCityId() {
			return cityId;
		}

		public void setCityId(int cityId) {
			this.cityId = cityId;
		}

		public LocalDateTime getUpdateTime() {
			return updateTime;
		}

		public void setUpdateTime(LocalDateTime updateTime) {
			this.updateTime = updateTime;
		}
	}
}
