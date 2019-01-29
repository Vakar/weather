package space.vakar.weather.domain.model.weather.location;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class SunTest extends AbstractJavaBeanTest<Sun> {

  @Override
  protected Sun getBeanInstance() {
    return new Sun();
  }
}
