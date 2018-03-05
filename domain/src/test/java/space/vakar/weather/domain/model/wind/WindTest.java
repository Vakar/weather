package space.vakar.weather.domain.model.wind;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.wind.Wind;

public class WindTest extends AbstractJavaBeanTest<Wind> {

  @Override
  protected Wind getBeanInstance() {
    return new Wind();
  }
}
