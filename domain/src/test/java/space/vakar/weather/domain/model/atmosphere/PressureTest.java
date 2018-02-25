package space.vakar.weather.domain.model.atmosphere;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.atmosphere.Pressure;

public class PressureTest extends AbstractJavaBeanTest<Pressure> {

  @Override
  protected Pressure getBeanInstance() {
    return new Pressure();
  }
}
