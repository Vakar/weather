package space.vakar.weather.domain.model.weather.atmosphere;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.atmosphere.Atmosphere;

public class AtmosphereTest extends AbstractJavaBeanTest<Atmosphere> {

  @Override
  protected Atmosphere getBeanInstance() {
    return new Atmosphere();
  }
}
