package space.vakar.weather.domain.model.weather.location;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.location.Sun;

public class SunTest extends AbstractJavaBeanTest<Sun> {

  @Override
  protected Sun getBeanInstance() {
    return new Sun();
  }
}
