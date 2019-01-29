package space.vakar.weather.domain.model.weather.atmosphere;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class PrecipitationTest extends AbstractJavaBeanTest<Precipitation> {

  @Override
  protected Precipitation getBeanInstance() {
    return new Precipitation();
  }
}
