package space.vakar.weather.domain.model.weather.location;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class CoordinatesTest extends AbstractJavaBeanTest<Coordinates> {

  @Override
  protected Coordinates getBeanInstance() {
    return new Coordinates();
  }
}
