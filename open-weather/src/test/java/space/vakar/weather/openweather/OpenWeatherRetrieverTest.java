package space.vakar.weather.openweather;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.localserver.LocalTestServer;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.junit.After;
import org.junit.Before;

public class OpenWeatherRetrieverTest {

	private LocalTestServer server = null;

	private HttpRequestHandler myHttpRequestHandler = new HttpRequestHandler() {
		@Override
		public void handle(HttpRequest request, HttpResponse response, HttpContext context)
				throws HttpException, IOException {
			response.setEntity(new StringEntity("foobar"));
		}
	};

	@Before
	public void setUp() throws Exception {
		LocalTestServer server = new LocalTestServer(null, null);
		server.start();
		server.register("/foo/*", myHttpRequestHandler);		
	}

	@After
	public void tearDown() throws Exception {
		server.stop();
	}

}
