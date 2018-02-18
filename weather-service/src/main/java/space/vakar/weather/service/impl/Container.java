package space.vakar.weather.service.impl;

import java.time.Duration;
import java.time.LocalDateTime;
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
		validatePositivOrZero(cityId);
		if (map.size() >= MAX_CAPACITY - 1)
			map.clear();
		weather.setLastUpdate(LocalDateTime.now());
		map.put(cityId, weather);
	}

	private void validateNotNull(Weather weather) {
		if (weather == null)
			throw new IllegalArgumentException();
	}

	private void validatePositivOrZero(int number) {
		if (number < 0)
			throw new IllegalArgumentException();
	}

	@Override
	public Weather pull(int cityId) {
		return map.get(cityId);
	}

	@Override
	public boolean isExist(int cityId) {
		return map.containsKey(cityId);
	}

	@Override
	public boolean isFresh(int cityId, Duration validDuration) {
		LocalDateTime lastUpdate = map.get(cityId).getLastUpdate();
		Duration d = Duration.between(lastUpdate, LocalDateTime.now());
		return d.getSeconds() < validDuration.getSeconds() ? true : false;
	}
}
