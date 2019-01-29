package space.vakar.weather.domain.model.weather.atmosphere;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class PressureTest extends AbstractJavaBeanTest<Pressure> {

  @Override
  protected Pressure getBeanInstance() {
    return new Pressure();
  }
}
