package space.vakar.weather.provider.openweather;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.localserver.LocalTestServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import space.vakar.weather.provider.openweather.Retriever;
import space.vakar.weather.provider.openweather.testutils.WeatherRequestHandler;

public class RetrieverTest {

	private Retriever weatherRetriever = new Retriever();
	private LocalTestServer server = new LocalTestServer(null, null);

	@Before
	public void setUp() throws Exception {
		server.start();
		server.register("/data/2.5/weather*", new WeatherRequestHandler());
		weatherRetriever.setServiceUrl("http:/" + server.getServiceAddress());
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

	@Test
	public void shouldReturnInputStream() throws IOException {		
		ClassLoader loader = getClass().getClassLoader();
		InputStream expected = loader.getResource("weather.xml").openStream();
		InputStream weather = weatherRetriever.requestCurrentWeatherXML("Moncton");
		assertTrue(IOUtils.contentEquals(expected, weather));
	}

}