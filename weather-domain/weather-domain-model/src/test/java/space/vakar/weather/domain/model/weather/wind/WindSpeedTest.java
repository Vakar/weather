package space.vakar.weather.domain.model.weather.wind;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class WindSpeedTest extends AbstractJavaBeanTest<WindSpeed> {

  @Override
  protected WindSpeed getBeanInstance() {
    return new WindSpeed();
  }
}
