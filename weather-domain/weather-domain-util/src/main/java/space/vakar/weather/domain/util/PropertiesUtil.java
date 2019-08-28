package space.vakar.weather.domain.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

  protected Properties readPropertiesFromFile(String fileName) throws IOException {
    Properties properties = new Properties();
    try (InputStream inputStream = PropertiesUtil.class.getResourceAsStream(fileName);) {
      properties.load(inputStream);
    }
    return properties;
  }

}
