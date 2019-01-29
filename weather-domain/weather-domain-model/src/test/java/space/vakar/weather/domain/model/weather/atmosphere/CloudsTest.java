package space.vakar.weather.domain.model.weather.atmosphere;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class CloudsTest extends AbstractJavaBeanTest<Clouds> {

  @Override
  protected Clouds getBeanInstance() {
    return new Clouds();
  }
}
