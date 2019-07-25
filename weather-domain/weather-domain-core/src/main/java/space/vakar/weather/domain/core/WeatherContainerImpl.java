package space.vakar.weather.domain.core;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import space.vakar.weather.domain.model.WeatherDTO;

class WeatherContainerImpl implements WeatherContainer {

	private static final long serialVersionUID = -5406341995470471507L;

	private static final Logger LOG = Logger.getLogger(WeatherContainerImpl.class);

	private Map<Integer, WeatherDTO> map = Collections.synchronizedMap(new TreeMap<>());

	private static final int MAX_CAPACITY = 1000;

	public Map<Integer, WeatherDTO> getMap() {
		return map;
	}

	public void setMap(Map<Integer, WeatherDTO> map) {
		this.map = map;
	}

	@Override
	public void push(WeatherDTO weather, int cityId) {
		validateNotNull(weather);
		cleanMapIfFull();
		LOG.debug("Push weather to container: " + new Gson().toJson(weather));
		map.put(cityId, weather);
	}

	private void validateNotNull(WeatherDTO weather) {
		if (weather == null) {
			throw new IllegalArgumentException();
		}
	}

	private void cleanMapIfFull() {
		if (map.size() >= MAX_CAPACITY) {
			map.clear();
		}
	}

	@Override
	public WeatherDTO pull(int cityId) {
		WeatherDTO weather = map.get(cityId);
		LOG.debug("Pull weather from container: " + new Gson().toJson(weather));
		return weather;
	}
}
