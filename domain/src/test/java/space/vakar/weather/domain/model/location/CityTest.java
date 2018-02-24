package space.vakar.weather.domain.model.location;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.location.City;

public class CityTest extends AbstractJavaBeanTest<City> {

	@Override
	protected City getBeanInstance() {
		return new City();
	}
}
