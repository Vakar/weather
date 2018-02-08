package space.vakar.weather.domain.model.atmosphere;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class AtmosphereTest extends AbstractJavaBeanTest<Atmosphere> {

	@Override
	protected Atmosphere getBeanInstance() {
		return new Atmosphere();
	}

}
