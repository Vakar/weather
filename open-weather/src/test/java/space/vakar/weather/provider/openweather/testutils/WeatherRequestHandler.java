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

	@Override
	public void handle(HttpRequest req, HttpResponse res, HttpContext context)
			throws HttpException, IOException {
		ClassLoader loader = getClass().getClassLoader();
		InputStream in = loader.getResource("weather.xml").openStream();
		res.setEntity(new InputStreamEntity(in));
	}

}
