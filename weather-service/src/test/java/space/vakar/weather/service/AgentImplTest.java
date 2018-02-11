package space.vakar.weather.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.github.benas.randombeans.api.EnhancedRandom;
import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.WeatherContainer;

@RunWith(MockitoJUnitRunner.class)
public class AgentImplTest {

	private Weather weather;

	@Mock
	private WeatherContainer container;

	@Mock
	private WeatherProvider provider;

	@InjectMocks
	private AgentImpl agent;

	@Before
	public void setUp() {
		weather = EnhancedRandom.random(Weather.class);
	}

	@Test
	public void shouldGetWeatherFromContainer_WhenWeatherInContainerAndFresh() {
		when(container.isExist("Moncton")).thenReturn(true);
		when(container.isFresh("Moncton")).thenReturn(true);
		when(container.pull("Moncton")).thenReturn(weather);
		assertEquals(weather, agent.weather("Moncton"));
	}
	
	@Test
	public void shouldGetWeatherFromProvider_WhenWeatherNotInContainer() {
		when(container.isExist("Moncton")).thenReturn(false);
		when(provider.provideWeather("Moncton")).thenReturn(weather);
		assertEquals(weather, agent.weather("Moncton"));
	}
	
	@Test
	public void shouldPushWeatherIntoContainer_WhenWeatherNotInContainer() {
		when(container.isExist("Moncton")).thenReturn(false);
		when(provider.provideWeather("Moncton")).thenReturn(weather);
		agent.weather("Moncton");
		verify(container).push(weather);
	}
	
	@Test
	public void shouldGetWeatherFromProvider_WhenWeatherInContainerAndIsNotFreshr() {
		when(container.isExist("Moncton")).thenReturn(true);
		when(container.isFresh("Moncton")).thenReturn(false);
		when(provider.provideWeather("Moncton")).thenReturn(weather);
		assertEquals(weather, agent.weather("Moncton"));
	}
	
	@Test
	public void shouldPushWeatherIntoContainer_WhenWeatherInContaineAndIsNotFreshr() {
		when(container.isExist("Moncton")).thenReturn(true);
		when(container.isFresh("Moncton")).thenReturn(false);
		when(provider.provideWeather("Moncton")).thenReturn(weather);
		agent.weather("Moncton");
		verify(container).push(weather);
	}
}
