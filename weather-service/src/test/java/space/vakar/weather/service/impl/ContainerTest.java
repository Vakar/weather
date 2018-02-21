package space.vakar.weather.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;
import java.util.Map;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;
import io.github.benas.randombeans.api.EnhancedRandom;
import space.vakar.weather.domain.model.Weather;

public class ContainerTest {

	private Container container;
	
	private Weather weatherA;
	private Weather weatherB;
	private Weather weatherC;

	private static final int WEATHER_A_CITY_ID = 1;
	private static final int WEATHER_B_CITY_ID = 2;
	private static final int WEATHER_C_CITY_ID = 3;
	private static final int MAX_CONTAINER_SIZE = 1000;

	@Before
	public void setUpContainer() {
		container = new Container();
		Map<Integer, Weather> map = new TreeMap<>();
		map.put(WEATHER_A_CITY_ID, weatherA);
		map.put(WEATHER_B_CITY_ID, weatherB);
		container.setMap(map);
	}

	@Before
	public void setUpWeather() {
		weatherA = EnhancedRandom.random(Weather.class);
		weatherB = EnhancedRandom.random(Weather.class);
		weatherC = EnhancedRandom.random(Weather.class);
	}

	@Test
	public void shouldPutObjectToContainer_WhenPushObjectNotNullValid() {
		container.push(weatherC, WEATHER_C_CITY_ID);
		assertEquals(weatherC, container.getMap().get(WEATHER_C_CITY_ID));
	}

	@Test
	public void shoulReplaceOldObjectFromContainer_WhenObjectWithTheSameCityIdExist() {
		Weather newWeatherA = EnhancedRandom.random(Weather.class);
		container.push(newWeatherA, WEATHER_A_CITY_ID);
		assertEquals(newWeatherA, container.getMap().get(WEATHER_A_CITY_ID));
	}

	@Test
	public void containerCapacityShouldNotBeBigger_Than1000() {
		Map<Integer, Weather> map = new TreeMap<>();
		for (int i = 0; i < MAX_CONTAINER_SIZE; i++) {
			map.put(i, weatherA);
		}
		container.setMap(map);
		assumeTrue(container.getMap().size() == MAX_CONTAINER_SIZE);
		container.push(weatherB, 1 + MAX_CONTAINER_SIZE);
		assertTrue(container.getMap().size() <= MAX_CONTAINER_SIZE);
	}

	@Test(expected = IllegalArgumentException.class)
	public void shouldThrowException_WhenObjectIsNull() {
		container.push(null, 23);
	}

	@Test
	public void shouldReturnWeatherByCityId_WhenExists() {
		assertEquals(weatherB, container.pull(WEATHER_B_CITY_ID));
	}

	@Test
	public void shouldReturnNull_WhenNotExist() {
		assertNull(container.pull(WEATHER_C_CITY_ID));
	}
}
