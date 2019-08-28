package space.vakar.open.weather.provider;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.weather.domain.model.WeatherDto;

@RunWith(MockitoJUnitRunner.class)
public class WeatherProviderImpTest {

  private static final int CITY_ID = 1;
  private static final String WEATHER_JSON_FILE = "weather.json";
    
  private WeatherDto weather = WeatherDtoPopulator.populate(new WeatherDto());

  @Mock
  private OpenWeatherClient apiClient;

  @InjectMocks
  private WeatherProviderImp provider;

  @Test
  public void provideWeatherTest() throws IOException{
    String weatherJson = getFileContent(WEATHER_JSON_FILE);
    when(apiClient.getCityWeatherJsonByCityId(CITY_ID)).thenReturn(weatherJson);
    Optional<WeatherDto> actualWeatherOpt = provider.provideWeather(CITY_ID);
    assertEquals(Optional.ofNullable(weather), actualWeatherOpt);
  }
  
  private  String getFileContent(String relatedPath) throws IOException {
    ClassLoader loader = WeatherProviderImpTest.class.getClassLoader();
    String path = loader.getResource(relatedPath).getPath();
    String content = null;
    try (Stream<String> lines = Files.lines(Paths.get(path))) {
      content = lines.collect(Collectors.joining(System.lineSeparator()));
    }
    return content;
  }

}
