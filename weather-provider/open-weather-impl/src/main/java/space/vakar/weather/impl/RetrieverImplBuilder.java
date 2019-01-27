package space.vakar.weather.impl;

import java.io.IOException;
import java.util.Properties;

import org.apache.http.impl.client.HttpClientBuilder;
import space.vakar.weather.exceptions.WeatherException;

public class RetrieverImplBuilder {

  private static final String OPEN_WEATHER_PROPERTIES_FILE = "/openweather.properties";

  private RetrieverImplBuilder() {}

  /**
   * Build {@link RetrieverImpl} object using openweather.properties file.
   *
   * @return object {@link RetrieverImpl} with all feeling fields for proper work
   */
  public static RetrieverImpl buildRetriever() {
    RetrieverImpl retriever = new RetrieverImpl();
    Properties properties = properties(OPEN_WEATHER_PROPERTIES_FILE);
    retriever.setHttpClient(HttpClientBuilder.create().build());
    retriever.setServiceUrl(properties.getProperty("open.weather.server.url"));
    retriever.setWeatherEndPoint(properties.getProperty("current.weather.end.point"));
    retriever.setAppId(properties.getProperty("app.id"));
    return retriever;
  }

  private static Properties properties(String fileName) {
    Properties properties = new Properties();
    try {
      properties.load(RetrieverImplBuilder.class.getResourceAsStream(fileName));
    } catch (IOException resourceException) {
      throw new WeatherException("Can't read OpenWeather properties file", resourceException);
    }
    return properties;
  }
}
