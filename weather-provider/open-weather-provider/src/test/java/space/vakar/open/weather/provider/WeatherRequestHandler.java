package space.vakar.open.weather.provider;

import java.io.UnsupportedEncodingException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;

public class WeatherRequestHandler implements HttpRequestHandler {
  private static final String VALID_URL = "/data/2.5/weather?id=1&APPID=valid_app_id";
  private static final String CITY_INVALID_URL = "/data/2.5/weather?id=0&APPID=valid_app_id";

  private static final String JSON = "{ \"weather\" : \"sunny\"}";

  @Override
  public void handle(HttpRequest req, HttpResponse res, HttpContext context) {
    String url = req.getRequestLine().getUri();
    if (VALID_URL.equals(url)) {
      try {
        res.setEntity(new StringEntity(JSON));
      } catch (UnsupportedEncodingException e) {
        throw new OpenWeatherException(e.getMessage(), e);
      }
    } else if (CITY_INVALID_URL.equals(url)) {
      res.setStatusCode(404);
    } else {
      res.setStatusCode(401);
    }
  }
}
