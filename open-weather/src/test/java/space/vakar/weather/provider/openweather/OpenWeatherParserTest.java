package space.vakar.weather.provider.openweather;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.testutils.CurrentWeatherPopulator;

public class OpenWeatherParserTest {
	
	CurrentWeather expectedWeather;
	
	InputStream inputStream;
	
	@Before
	public void setUp() throws IOException {
		expectedWeather = new CurrentWeather();
		CurrentWeatherPopulator.populateData(expectedWeather);
		ClassLoader loader = getClass().getClassLoader();
		inputStream = loader.getResource("weather.xml").openStream();
	}
	
	@Test
	public void shouldReturnCorrectObject() throws JAXBException {
		assertEquals(expectedWeather, Parser.parse(inputStream));		
	}
}
