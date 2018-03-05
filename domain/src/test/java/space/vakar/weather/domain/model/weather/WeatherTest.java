package space.vakar.weather.domain.model.weather;

import space.vakar.weather.domain.model.weather.Weather;

public class WeatherTest extends AbstractJavaBeanTest<Weather> {

  @Override
  protected Weather getBeanInstance() {
    return new Weather();
  }
}
