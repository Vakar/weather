package space.vakar.weather.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.validation.ValidationException;

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
	
	private Weather weatherWithNullFields;

	@Mock
	private WeatherContainer container;

	@Mock
	private WeatherProvider provider;

	@InjectMocks
	private AgentImpl agent;

	@Before
	public void setUp() {
		weather = EnhancedRandom.random(Weather.class);
		weatherWithNullFields = new Weather();
	}

	@Test
	public void shouldGetWeatherFromContainer_WhenWeatherInContainerAndFresh() {
		when(container.isExist(1)).thenReturn(true);
		when(container.isFresh(1)).thenReturn(true);
		when(container.pull(1)).thenReturn(weather);
		assertEquals(weather, agent.weather(1));
	}
	
	@Test
	public void shouldGetWeatherFromProvider_WhenWeatherNotInContainer() throws Exception {
		when(container.isExist(1)).thenReturn(false);
		when(provider.provideWeather(1)).thenReturn(weather);
		assertEquals(weather, agent.weather(1));
	}
	
	@Test
	public void shouldPushWeatherIntoContainer_WhenWeatherNotInContainer() throws Exception {
		when(container.isExist(1)).thenReturn(false);
		when(provider.provideWeather(1)).thenReturn(weather);
		agent.weather(1);
		verify(container).push(weather);
	}
	
	@Test
	public void shouldGetWeatherFromProvider_WhenWeatherInContainerAndIsNotFreshr() throws Exception {
		when(container.isExist(1)).thenReturn(true);
		when(container.isFresh(1)).thenReturn(false);
		when(provider.provideWeather(1)).thenReturn(weather);
		assertEquals(weather, agent.weather(1));
	}
	
	@Test
	public void shouldPushWeatherIntoContainer_WhenWeatherInContaineAndIsNotFresh() throws Exception {
		when(container.isExist(1)).thenReturn(true);
		when(container.isFresh(1)).thenReturn(false);
		when(provider.provideWeather(1)).thenReturn(weather);
		agent.weather(1);
		verify(container).push(weather);
	}
	
	@Test(expected = ValidationException.class)
	public void shouldThrowException_WhenFieldsHaveNullValue() throws Exception {
		when(container.isExist(1)).thenReturn(false);
		when(provider.provideWeather(1)).thenReturn(weatherWithNullFields);
		agent.weather(1);
	}
}
