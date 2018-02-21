package space.vakar.weather.service.impl;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.WeatherContainer;

public class Container implements WeatherContainer {

	private Map<Integer, Weather> map = Collections
			.synchronizedMap(new TreeMap<>());

	private static final int MAX_CAPACITY = 1000;

	public Map<Integer, Weather> getMap() {
		return map;
	}

	public void setMap(Map<Integer, Weather> map) {
		this.map = map;
	}

	@Override
	public void push(Weather weather, int cityId) {
		validateNotNull(weather);
		cleanMapIfFull();
		map.put(cityId, weather);
	}

	private void validateNotNull(Weather weather) {
		if (weather == null)
			throw new IllegalArgumentException();
	}
	
	private void cleanMapIfFull() {
	  if (map.size() >= MAX_CAPACITY)
        map.clear();
	}

	@Override
	public Weather pull(int cityId) {
		return map.get(cityId);
	}
}
