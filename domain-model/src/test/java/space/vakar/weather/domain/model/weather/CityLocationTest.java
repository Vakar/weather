package space.vakar.weather.domain.model.weather;

import space.vakar.weather.domain.model.location.CityLocation;

public class CityLocationTest extends AbstractJavaBeanTest<CityLocation> {

  @Override
  protected CityLocation getBeanInstance() {
    return new CityLocation();
  }
}
