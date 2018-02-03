package space.vakar.weather.openweather;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.localserver.LocalTestServer;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class OpenWeatherRetrieverTest {
	
	private OpenWeatherRetriever openWeatherRetriever = new OpenWeatherRetriever();

	private LocalTestServer server = null;

	private HttpRequestHandler myHttpRequestHandler = null;

	@Before
	public void setUp() throws Exception {
		server = new LocalTestServer(null, null);
		server.start();		
		InputStream in = getClass().getClassLoader().getResource("currentWeather.xml").openStream();
		
		myHttpRequestHandler = new HttpRequestHandler() {
			@Override
			public void handle(HttpRequest request, HttpResponse response, HttpContext context)
					throws HttpException, IOException {
				response.setEntity(new InputStreamEntity(in));
			}
		};
		
		server.register("/data/2.5/*", myHttpRequestHandler);
		
		String serverUrl = "http:/" + server.getServiceAddress();
		openWeatherRetriever.setOpenWeatherURL(serverUrl);
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}
	
	@Test
	public void shouldReturnInputStream() throws IOException {
		InputStream inputStream = openWeatherRetriever.retrieveCurrantWeatherXML("Moncton");
		InputStream in = getClass().getClassLoader().getResource("currentWeather.xml").openStream();
		IOUtils.contentEquals( in, inputStream );
	}

}
