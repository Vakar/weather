package space.vakar.weather.domain.model.atmosphere;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class PressureTest extends AbstractJavaBeanTest<Pressure> {

	@Override
	protected Pressure getBeanInstance() {
		return new Pressure();
	}

}
