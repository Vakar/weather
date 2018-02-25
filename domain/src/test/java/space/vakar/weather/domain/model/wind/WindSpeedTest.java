package space.vakar.weather.domain.model.wind;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.wind.WindSpeed;

public class WindSpeedTest extends AbstractJavaBeanTest<WindSpeed> {

  @Override
  protected WindSpeed getBeanInstance() {
    return new WindSpeed();
  }
}
