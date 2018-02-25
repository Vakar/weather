package space.vakar.weather.provider.openweather;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.apache.http.impl.client.HttpClientBuilder;

public class RetrieverBuilder {

  private static final String OPEN_WEATHER_PROPERTIES_FILE = "openweather.properties";

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
    File file = file(fileName);
    Properties properties = new Properties();
    try (FileInputStream fileInput = new FileInputStream(file);) {
      properties.load(fileInput);
    } catch (IOException e) {
      throw new OpenWeatherException("Can't read OpenWeather properties file", e);
    }
    return properties;
  }

  private static File file(String fileName) {
    ClassLoader classLoader = new Retriever().getClass().getClassLoader();
    return new File(classLoader.getResource(fileName).getFile());
  }

}
