package space.vakar.weather.domain.model.atmosphere;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class PrecipitationTest extends AbstractJavaBeanTest<Precipitation> {

	@Override
	protected Precipitation getBeanInstance() {
		return new Precipitation();
	}

}
