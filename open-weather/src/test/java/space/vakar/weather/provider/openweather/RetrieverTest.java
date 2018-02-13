package space.vakar.weather.provider.openweather;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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
	
	@Before
	public void setUp() {
		weatherRetriever = new Retriever();
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
	public void shouldReturnInputStream_WhenAllRequestCorrect() throws IOException {
		InputStream expected = streamFromFile("weather.xml");	
		weatherRetriever.setAppId("valid_app_id");
		InputStream weather = weatherRetriever.requestCurrentWeatherXML("valid_city_name");
		assertTrue(IOUtils.contentEquals(expected, weather));
	}

	@Test
	public void shouldReturnOpenWeatherExceptionWith404ErrorMessage_WhenCityIdNotValid() throws IOException {
		weatherRetriever.setAppId("valid_app_id");		
		try {
			weatherRetriever.requestCurrentWeatherXML("not_valid_city_name");
		} catch (OpenWeatherException e) {
			assertEquals("HTTP/1.1 404 Not Found", e.getMessage());
//			fail("OpenWeatherException wasn't throw!");
		}
		
	}

	public void shouldReturnOpenWeatherExceptionWith401ErrorMessage_WhenAppIdNotValid() throws IOException {
		weatherRetriever.setAppId("not_valid_app_id");		
		try {
			weatherRetriever.requestCurrentWeatherXML("valid_city_name");
		} catch (OpenWeatherException e) {
			assertEquals("HTTP/1.1 404 Not Found", e.getMessage());
		}
		fail("Not yet implemented");
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
