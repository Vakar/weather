package space.vakar.weather.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeTrue;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;

import io.github.benas.randombeans.api.EnhancedRandom;
import space.vakar.weather.domain.model.Weather;

public class ContainerTest {

	private Container container;

	private Weather weatherA;
	private Weather weatherB;
	private Weather weatherC;
	
	private int cityId;

	@Before
	public void setUp() {
		weatherA = EnhancedRandom.random(Weather.class);
		weatherB = EnhancedRandom.random(Weather.class);
		weatherC = EnhancedRandom.random(Weather.class);
		cityId = 1;
		container = new Container();
		container.getStack().addLast(
				container.new Node(weatherA, 1, LocalDateTime.now()));
		container.getStack().addLast(
				container.new Node(weatherB, 3, LocalDateTime.now()));
	}

	@Test
	public void shouldReturnFalse_WhenContainerDoesNotHaveNodeWithSearchingCityId() {
		assertFalse(container.isExist(2));
	}

	@Test
	public void shouldReturnTrue_WhenContainerHaveNodeWithSearchingCityId() {
		assertTrue(container.isExist(1));
	}
	
	@Test
	public void shouldReturnWeatherByCityId_WhenExists() {
		assertEquals(weatherB, container.pull(3));
	}
	
	@Test
	public void shouldReturnNull_WhenNotExist() {
		assertNull(container.pull(33));
	}

	@Test
	public void shouldSetObjectFirst_WhenPushObjectToContainer() {
		assumeTrue(!container.getStack().isEmpty());
		assumeTrue(!weatherC.equals(container.getStack().getFirst().getWeather()));
		container.push(weatherC, 23);
		assertEquals(weatherC, container.getStack().getFirst().getWeather());
	}

	public void containerCapacityShouldNotBeBiggerThan_1000() {
		fail("Not yet implemented");
	}

	public void shouldRemoveObjectWithSameCityName_WhenPushNewObject() {
		fail("Not yet implemented");
	}

}
