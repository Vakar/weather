package space.vakar.weather.domain.model.atmosphere;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.atmosphere.Clouds;

public class CloudsTest extends AbstractJavaBeanTest<Clouds> {

  @Override
  protected Clouds getBeanInstance() {
    return new Clouds();
  }
}
