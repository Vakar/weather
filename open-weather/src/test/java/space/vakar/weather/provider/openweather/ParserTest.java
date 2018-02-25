package space.vakar.weather.provider.openweather;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.xml.sax.SAXException;

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
  InputStream weatherStream;
  InputStream notValidWeatherStream;

  @Before
  public void setUp() throws IOException {
    expectedWeather = new CurrentWeather();
    CurrentWeatherPopulator.populateData(expectedWeather);
    ClassLoader loader = getClass().getClassLoader();
    weatherStream = loader.getResource("weather.xml").openStream();
    notValidWeatherStream = loader.getResource("notValidWeather.xml").openStream();
  }

  @Test
  public void shouldReturnCorrectObject() throws JAXBException, IOException, SAXException {
    when(retriverMock.weatherXml(1)).thenReturn(weatherStream);
    assertEquals(expectedWeather, parser.weather(1));
  }
  
  @Test(expected = OpenWeatherException.class)
  public void shouldThrowException_WhenParsingNotValidXML() throws Exception {
    when(retriverMock.weatherXml(1)).thenReturn(notValidWeatherStream);  
    parser.weather(1);
  }
}
