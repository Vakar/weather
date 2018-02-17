package space.vakar.weather.service;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Deque;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.WeatherContainer;

public class Container implements WeatherContainer {
	
	private Deque<Weather> stack = new ArrayDeque<>();	

	@Override
	public void push(Weather weather) {
		// TODO Auto-generated method stub
	}

	@Override
	public Weather pull(int cityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isExist(int citId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isFresh(int cityId) {
		// TODO Auto-generated method stub
		return false;
	}

	class Node {
		private Weather weather;
		private String cityName;
		private LocalDateTime updateTime;
	}
}
