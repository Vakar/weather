package space.vakar.weather.provider.openweather;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.*;

import space.vakar.weather.provider.openweather.api.WeatherRetriever;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.testutils.CurrentWeatherPopulator;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {
	
	@Mock
	WeatherRetriever retriverMock;
	
	@InjectMocks
	Parser parser;
	
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
	public void shouldReturnCorrectObject() throws JAXBException, IOException {		
		when(retriverMock.weatherXML(1)).thenReturn(inputStream);		
		assertEquals(expectedWeather, parser.currentWeather(1));
	}
}
