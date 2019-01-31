package space.vakar.open.weather.impl;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.open.weather.api.Retriever;
import space.vakar.open.weather.model.CurrentWeather;
import space.vakar.open.weather.testutils.CurrentWeatherPopulator;

import java.io.IOException;
import java.io.InputStream;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {

  @Mock private Retriever retriverMock;

  private ParserImpl parser;

  private CurrentWeather expectedWeather;

  private InputStream weatherStream;
  private InputStream notValidWeatherStream;

  @Before
  public void setUpParser() {
    parser = new ParserImpl(retriverMock);
  }

  @Before
  public void setUpWeather() {
    expectedWeather = new CurrentWeather();
    CurrentWeatherPopulator.populateData(expectedWeather);
  }

  @Before
  public void setUpInputStreams() throws IOException {
    ClassLoader loader = getClass().getClassLoader();
    weatherStream = loader.getResource("weather.xml").openStream();
    notValidWeatherStream = loader.getResource("notValidWeather.xml").openStream();
  }

  @Test
  public void shouldReturnCorrectObject() {
    when(retriverMock.weatherXml(1)).thenReturn(weatherStream);
    Assert.assertEquals(expectedWeather, parser.weather(1));
  }

  @Test(expected = OpenWeatherException.class)
  public void shouldThrowOpenWeatherException_WhenParsingNotValidXml() {
    when(retriverMock.weatherXml(1)).thenReturn(notValidWeatherStream);
    parser.weather(1);
  }
}
