package space.vakar.weather.provider.openweather.impl;

import java.io.IOException;
import java.util.Properties;
import org.apache.http.impl.client.HttpClientBuilder;
import space.vakar.weather.provider.openweather.exceptions.OpenWeatherException;

public class RetrieverBuilder {

  private static final String OPEN_WEATHER_PROPERTIES_FILE = "/openweather.properties";

  private RetrieverBuilder() {

  }

  /**
   * Build {@link Retriever} object using openweather.properties file.
   *
   * @return object {@link Retriever} with all feeling fields for proper work
   */
  public static Retriever buildRetriever() {
    Retriever retriever = new Retriever();
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
      properties.load(RetrieverBuilder.class.getResourceAsStream(fileName));
    } catch (IOException e) {
      throw new OpenWeatherException("Can't read OpenWeather properties file", e);
    }
    return properties;
  }

}
