package space.vakar.weather.provider.openweather.testutils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

public class WeatherRequestHandler implements HttpRequestHandler{
	
	private static final String VALID_URL = "/data/2.5/weather?id=1&APPID=valid_app_id&mode=xml";
	private static final String CITY_NOT_VALID_URL = "/data/2.5/weather?id=-1&APPID=valid_app_id&mode=xml";
	private static final String APPID_NOT_VALID_URL = "/data/2.5/weather?id=1&APPID=not_valid_app_id&mode=xml";
	
	@Override
	public void handle(HttpRequest req, HttpResponse res, HttpContext context)
			throws HttpException, IOException {
		String url = req.getRequestLine().getUri();
		if(VALID_URL.equals(url)) {
			InputStream stream = streamFromFile("weather.xml");
			res.setEntity(new InputStreamEntity(stream));
		} else if(CITY_NOT_VALID_URL.equals(url)) {
			res.setStatusCode(404);
		} else if(APPID_NOT_VALID_URL.equals(url)) {
			res.setStatusCode(401);
		}
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
