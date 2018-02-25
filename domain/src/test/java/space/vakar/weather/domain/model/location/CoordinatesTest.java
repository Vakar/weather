package space.vakar.weather.domain.model.location;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.location.Coordinates;

public class CoordinatesTest extends AbstractJavaBeanTest<Coordinates> {

  @Override
  protected Coordinates getBeanInstance() {
    return new Coordinates();
  }
}
