package space.vakar.weather.domain.model.weather.atmosphere;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.atmosphere.Precipitation;

public class PrecipitationTest extends AbstractJavaBeanTest<Precipitation> {

  @Override
  protected Precipitation getBeanInstance() {
    return new Precipitation();
  }
}
