package space.vakar.open.weather.impl;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.log4j.Logger;
import space.vakar.open.weather.api.Retriever;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

class RetrieverImpl implements Retriever {

  private static final Logger LOG = Logger.getLogger(RetrieverImpl.class);

  private HttpClient httpClient;

  private String serviceUrl;
  private String weatherEndPoint;
  private String appId;

  @Override
  public InputStream weatherXml(int cityId) {
    HttpResponse response = httpGetRequest(weatherXmlUrl(cityId));
    validateResponce(response);
    return streamFrom(response);
  }

  private HttpResponse httpGetRequest(String url) {
    HttpResponse response = null;
    LOG.debug("TRY: to make GET request to OpenWeather server: " + url);
    try {
      response = httpClient.execute(new HttpGet(url));
    } catch (IOException requestException) {
      throw new OpenWeatherException("Can't get response from server", requestException);
    }
    LOG.debug("SUCCESS: get response from OpenWeather server");
    return response;
  }

  private String weatherXmlUrl(int cityId) {
    String urlFormat = "%s%s?id=%s&APPID=%s&mode=xml";
    return String.format(urlFormat, serviceUrl, weatherEndPoint, cityId, appId);
  }

  private void validateResponce(HttpResponse response) {
    int statusCode = response.getStatusLine().getStatusCode();
    if (statusCode != 200) {
      throw new OpenWeatherException(
          "Server response status code: " + response.getStatusLine().toString());
    }
  }

  private InputStream streamFrom(HttpResponse res) {
    InputStream in = null;
    try {
      in = res.getEntity().getContent();
    } catch (IOException responseContentException) {
      throw new OpenWeatherException(
          "Can't open InputStream from HttpResponse", responseContentException);
    }
    return in;
  }

  public HttpClient getHttpClient() {
    return httpClient;
  }

  public void setHttpClient(HttpClient httpClient) {
    this.httpClient = httpClient;
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

  public void setAppId(String appId) {
    this.appId = appId;
  }

  @Override
  public int hashCode() {
    return Objects.hash(serviceUrl, weatherEndPoint);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof RetrieverImpl) {
      RetrieverImpl that = (RetrieverImpl) object;
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
