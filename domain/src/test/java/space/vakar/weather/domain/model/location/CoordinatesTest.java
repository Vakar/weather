package space.vakar.weather.domain.model.location;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class CoordinatesTest extends AbstractJavaBeanTest<Coordinates> {

	@Override
	protected Coordinates getBeanInstance() {
		return new Coordinates();
	}

}
