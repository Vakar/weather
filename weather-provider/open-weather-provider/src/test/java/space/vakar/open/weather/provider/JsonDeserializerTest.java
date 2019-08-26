package space.vakar.open.weather.provider;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.junit.Before;
import org.junit.Test;
import space.vakar.open.weather.provider.ApiClientBuilder;
import space.vakar.open.weather.provider.JsonDeserializer;
import space.vakar.weather.domain.model.WeatherDto;

public class JsonDeserializerTest {

  private static final String WEATHER_JSON_FILE_PATH = "/weather.json";
  private static final String NEW_LINE = System.lineSeparator();

  private WeatherDto expectedWeatherTto;

  @Before
  public void setUp() {
    expectedWeatherTto = new WeatherDto();
    WeatherDtoPopulator.populate(expectedWeatherTto);
  }

  @Test
  public void shouldConvertJsonToWeatherDto_WhenJsonValid() {
    String weatherJson = readFile(WEATHER_JSON_FILE_PATH);
    WeatherDto actualWeatherDto = JsonDeserializer.convertJsonToWeatherDto(weatherJson);
    assertEquals(expectedWeatherTto, actualWeatherDto);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowIlligalArgumentException_WhenInputNull() {
    JsonDeserializer.convertJsonToWeatherDto(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowIlligalArgumentException_WhenInputEmptyString() {
    JsonDeserializer.convertJsonToWeatherDto("");
  }

  @Test(expected = IllegalArgumentException.class)
  public void shouldThrowIlligalArgumentException_WhenInputBlankString() {
    JsonDeserializer.convertJsonToWeatherDto(" ");
  }

  private static String readFile(String filePath) {
    StringBuilder contentBuilder = new StringBuilder();
    String uri = ApiClientBuilder.class.getResource(filePath).getPath();
    try (Stream<String> stream = Files.lines(Paths.get(uri), StandardCharsets.UTF_8)) {
      stream.forEach(s -> contentBuilder.append(s).append(NEW_LINE));
    } catch (IOException e) {
      e.printStackTrace();
    }
    return contentBuilder.toString();
  }

}
