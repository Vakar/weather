package space.vakar.weather.provider.openweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.io.IOException;
import java.io.InputStream;
import org.apache.commons.io.IOUtils;
import org.apache.http.localserver.LocalTestServer;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import space.vakar.weather.provider.openweather.testutils.WeatherRequestHandler;

public class RetrieverTest {
  
	private Retriever weatherRetriever;
	private static LocalTestServer server;
	
	private static final int VALID_CITY_ID = 1;
	private static final int NOT_VALID_CITY_ID = -1;
	
	@Before
	public void setUp() {
		weatherRetriever = RetrieverBuilder.buildRetriever();
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
	public void shouldReturnInputStream_WhenAllUrlCorrect() throws IOException, OpenWeatherException {
		InputStream expected = streamFromFile("weather.xml");	
		weatherRetriever.setAppId("valid_app_id");
		InputStream weather = weatherRetriever.weatherXML(VALID_CITY_ID);
		assertTrue(IOUtils.contentEquals(expected, weather));
	}

	@Test
	public void shouldReturnOpenWeatherExceptionWith404ErrorMessage_WhenCityIdNotValid() throws IOException {
		String message = null;			
		try {
			weatherRetriever.setAppId("valid_app_id");	
			weatherRetriever.weatherXML(NOT_VALID_CITY_ID);
		} catch (OpenWeatherException e) {
			message = e.getMessage();
		}
		assertEquals("OpenWeather server response status code: HTTP/1.1 404 Not Found", message);
	}

	@Test
	public void shouldReturnOpenWeatherExceptionWith401ErrorMessage_WhenAppIdNotValid() throws IOException {
		String message = null;				
		try {
			weatherRetriever.setAppId("not_valid_app_id");
			weatherRetriever.weatherXML(VALID_CITY_ID);
		} catch (OpenWeatherException e) {
			message = e.getMessage();
		}
		assertEquals("OpenWeather server response status code: HTTP/1.1 401 Unauthorized", message);
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
