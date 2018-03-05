package space.vakar.weather.domain.model.weather.location;

import space.vakar.weather.domain.model.weather.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.weather.location.City;

public class CityTest extends AbstractJavaBeanTest<City> {

  @Override
  protected City getBeanInstance() {
    return new City();
  }
}
