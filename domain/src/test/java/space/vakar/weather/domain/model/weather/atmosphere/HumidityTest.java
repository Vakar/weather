package space.vakar.weather.domain.model.weather.atmosphere;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.atmosphere.Humidity;

public class HumidityTest extends AbstractJavaBeanTest<Humidity> {

  @Override
  protected Humidity getBeanInstance() {
    return new Humidity();
  }
}