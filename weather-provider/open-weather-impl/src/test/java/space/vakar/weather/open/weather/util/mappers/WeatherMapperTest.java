package space.vakar.weather.open.weather.util.mappers;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.open.weather.model.CurrentWeather;
import space.vakar.weather.testutils.CurrentWeatherPopulator;
import space.vakar.weather.testutils.WeatherPopulator;


public class WeatherMapperTest {

  private Weather expectedWeather;
  private CurrentWeather currentWeather;

  @Before
  public void setUp() {
    expectedWeather = new Weather();
    WeatherPopulator.populate(expectedWeather);
    currentWeather = new CurrentWeather();
    CurrentWeatherPopulator.populateData(currentWeather);
  }

  @Test
  public void souldConvertProperly() {
    assertEquals(expectedWeather, GetWeather.from(currentWeather));
  }
}
