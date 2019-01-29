package space.vakar.weather.domain.model.weather.location;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;

public class LocationTest extends AbstractJavaBeanTest<Location> {

  @Override
  protected Location getBeanInstance() {
    return new Location();
  }
}
