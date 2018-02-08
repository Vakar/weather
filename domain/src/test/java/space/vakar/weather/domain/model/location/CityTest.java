package space.vakar.weather.domain.model.location;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class CityTest extends AbstractJavaBeanTest<City> {

	@Override
	protected City getBeanInstance() {
		return new City();
	}

}
