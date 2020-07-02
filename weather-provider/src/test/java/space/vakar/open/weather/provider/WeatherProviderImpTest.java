package space.vakar.open.weather.provider;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import space.vakar.weather.domain.model.WeatherDto;

@ExtendWith(MockitoExtension.class)
public class WeatherProviderImpTest {

  private static final String WEATHER_JSON_FILE = "weather.json";

  @Mock private OpenWeatherClient apiClient;

  @InjectMocks private WeatherProviderImp provider;

  @Test
  @DisplayName("when get weather json from api client")
  public void provideWeatherTest() throws IOException {
    String weatherJson = getFileContent();
    int cityId = 1;
    when(apiClient.getCityWeatherJsonByCityId(cityId)).thenReturn(weatherJson);
    Optional<WeatherDto> actualWeatherOpt = provider.provideWeatherForCityWithId(cityId);
    WeatherDto weather = Populator.populate(new WeatherDto());
    assertEquals(Optional.of(weather), actualWeatherOpt, "should return weather optional");
  }

  private String getFileContent() throws IOException {
    ClassLoader loader = WeatherProviderImpTest.class.getClassLoader();
    String path =
        Objects.requireNonNull(loader.getResource(WeatherProviderImpTest.WEATHER_JSON_FILE))
            .getPath();
    String content;
    try (Stream<String> lines = Files.lines(Paths.get(path))) {
      content = lines.collect(Collectors.joining(System.lineSeparator()));
    }
    return content;
  }
}
