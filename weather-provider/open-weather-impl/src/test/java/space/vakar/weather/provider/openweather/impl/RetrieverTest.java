package space.vakar.weather.provider.openweather.impl;

import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.http.localserver.LocalTestServer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import space.vakar.weather.provider.openweather.exceptions.WeatherRetrieverException;
import space.vakar.weather.provider.openweather.testutils.WeatherRequestHandler;

public class RetrieverTest {

  private RetrieverImpl weatherRetriever;

  private static LocalTestServer server;

  private static final int VALID_CITY_ID = 1;
  private static final int NOT_VALID_CITY_ID = -1;

  @Before
  public void setUp() throws WeatherRetrieverException {
    weatherRetriever = RetrieverImplBuilder.buildRetriever();
    weatherRetriever.setServiceUrl("http:/" + server.getServiceAddress());
  }

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    server = new LocalTestServer(null, null);
    server.start();
    server.register("/data/2.5/*", new WeatherRequestHandler());
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
    server.stop();
  }

  @Test
  public void shouldReturnInputStream_WhenAllUrlCorrect()
      throws WeatherRetrieverException, IOException {
    InputStream expected = streamFromFile("weather.xml");
    weatherRetriever.setAppId("valid_app_id");
    InputStream weather = weatherRetriever.weatherXml(VALID_CITY_ID);
    assertTrue(IOUtils.contentEquals(expected, weather));
  }

  @Test(expected = WeatherRetrieverException.class)
  public void shouldReturnOpenWeatherRetrieverException_WhenCityIdNotValid()
      throws WeatherRetrieverException {
    weatherRetriever.setAppId("valid_app_id");
    weatherRetriever.weatherXml(NOT_VALID_CITY_ID);
  }

  @Test(expected = WeatherRetrieverException.class)
  public void shouldReturnOpenWeatherRetrieverException_WhenAppIdNotValid()
      throws WeatherRetrieverException {
    weatherRetriever.setAppId("not_valid_app_id");
    weatherRetriever.weatherXml(VALID_CITY_ID);
  }

  private InputStream streamFromFile(String filePath) {
    ClassLoader loader = getClass().getClassLoader();
    InputStream stream;
    try {
      stream = loader.getResource(filePath).openStream();
    } catch (IOException e) {
      throw new IllegalArgumentException("File not found: " + filePath);
    }
    return stream;
  }
}
