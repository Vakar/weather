package space.vakar.weather.domain.model.weather.temperature;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.temperature.Temperature;

public class TemperatureTest extends AbstractJavaBeanTest<Temperature> {

  @Override
  protected Temperature getBeanInstance() {
    return new Temperature();
  }

}
