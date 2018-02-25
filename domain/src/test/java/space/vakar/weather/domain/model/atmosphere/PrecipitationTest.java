package space.vakar.weather.domain.model.atmosphere;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.atmosphere.Precipitation;

public class PrecipitationTest extends AbstractJavaBeanTest<Precipitation> {

  @Override
  protected Precipitation getBeanInstance() {
    return new Precipitation();
  }
}
