package space.vakar.open.weather.provider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

@Getter
@EqualsAndHashCode
@ToString
class OpenWeatherClientImp implements OpenWeatherClient {

  private HttpClient httpClient = HttpClientBuilder.create().build();

  private static final int HTTP_OK = 200;
  private static final int HTTP_UNAUTHORIZED = 401;
  private static final int HTTP_NOT_FOUND = 404;

  private static final String INVALID_CITY_ID_MESSAGE = "Can't found city by id.";
  private static final String INVALID_APP_ID_MESSAGE =
      "Invalid API key. Please see http://openweathermap.org/faq#error401 for more info.";

  private String serviceUrl;
  private String weatherEndPoint;
  private String appId;

  OpenWeatherClientImp() {
    this(OpenWeatherProperties.getInstance());
  }

  OpenWeatherClientImp(OpenWeatherProperties prop) {
    this(prop.getUrl(), prop.getEndPoint(), prop.getKey());
  }

  OpenWeatherClientImp(String serviceUrl, String weatherEndPoint, String appId) {
    this.serviceUrl = serviceUrl;
    this.weatherEndPoint = weatherEndPoint;
    this.appId = appId;
  }

  @Override
  public String getCityWeatherJsonByCityId(int cityId) {
    String jsonResponse = "";
    try {
      String urlString = formatUrl(cityId);
      HttpResponse response = httpClient.execute(new HttpGet(urlString));
      int statusCode = response.getStatusLine().getStatusCode();
      if (statusCode == HTTP_OK) {
        InputStream in = response.getEntity().getContent();
        jsonResponse = readResponseBody(in);
      } else if (statusCode == HTTP_NOT_FOUND) {
        throw new OpenWeatherProviderException(INVALID_CITY_ID_MESSAGE);
      } else if (statusCode == HTTP_UNAUTHORIZED) {
        throw new OpenWeatherProviderException(INVALID_APP_ID_MESSAGE);
      }
    } catch (IOException e) {
      throw new OpenWeatherProviderException(e.getMessage());
    }
    return jsonResponse;
  }

  private String formatUrl(int cityId) {
    String urlFormat = "%s%s?id=%s&APPID=%s";
    return String.format(urlFormat, serviceUrl, weatherEndPoint, cityId, appId);
  }

  private String readResponseBody(InputStream in) throws IOException {
    BufferedReader bufReader =
        new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
    String inputLine;
    StringBuilder response = new StringBuilder();
    while ((inputLine = bufReader.readLine()) != null) {
      response.append(inputLine);
    }
    in.close();
    return response.toString();
  }
}
