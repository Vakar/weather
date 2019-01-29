package space.vakar.weather.domain.model.weather.atmosphere;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class AtmosphereTest extends AbstractJavaBeanTest<Atmosphere> {

  @Override
  protected Atmosphere getBeanInstance() {
    return new Atmosphere();
  }
}
