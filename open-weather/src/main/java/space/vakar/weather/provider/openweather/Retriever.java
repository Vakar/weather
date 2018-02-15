package space.vakar.weather.provider.openweather;

import java.io.InputStream;
import java.util.Objects;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import space.vakar.weather.provider.openweather.api.WeatherRetriever;

class Retriever implements WeatherRetriever {

  private String serviceUrl = "http://api.openweathermap.org";
  private String weatherEndPoint = "/data/2.5/weather";
  private String appId = "eede123ce615f9cc56910f9a0e024e3a";
  private HttpClient httpClient = HttpClientBuilder.create().build();

  public InputStream weatherXML(int cityId) {
    HttpResponse res =  responseHttpGet(weatherXmlUrl(cityId));
    validateResponce(res);
    return streamFrom(res);
  }
  
  private HttpResponse responseHttpGet(String url) {
    HttpResponse res;
    try {
       res = httpClient.execute(new HttpGet(url));
    } catch (Exception e) {
      throw new OpenWeatherException("Can't get responce from server");
    } 
    return res;
  }

  private String weatherXmlUrl(int cityId) {
    return serviceUrl + weatherEndPoint + "?id=" + cityId + "&APPID=" + appId + "&mode=xml";
  }

  private void validateResponce(HttpResponse response) throws OpenWeatherException {
    int statusCode = response.getStatusLine().getStatusCode();
    if (statusCode != 200) {
      throw new OpenWeatherException(response.getStatusLine().toString());
    }
  }

  private InputStream streamFrom(HttpResponse res) {
    InputStream in;
    try {
      in = res.getEntity().getContent();
   } catch (Exception e) {
     throw new OpenWeatherException("Can't open InputStream from HttpResponse");
   } 
    return in;
  }

  public String getServiceUrl() {
    return serviceUrl;
  }

  public void setServiceUrl(String serviceUrl) {
    this.serviceUrl = serviceUrl;
  }

  public String getWeatherEndPoint() {
    return weatherEndPoint;
  }

  public void setWeatherEndPoint(String weatherEndPoint) {
    this.weatherEndPoint = weatherEndPoint;
  }

  public String getAppId() {
    return appId;
  }

  public void setAppId(String aPPID) {
    appId = aPPID;
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceUrl, weatherEndPoint);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof Retriever) {
      Retriever that = (Retriever) object;
      return Objects.equals(this.serviceUrl, that.serviceUrl)
          && Objects.equals(this.weatherEndPoint, that.weatherEndPoint);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "OpenWeatherRetriever [serviceUrl=%s, weatherEndPoint=%s]";
    return String.format(format, serviceUrl, weatherEndPoint);
  }
}
