package space.vakar.weather.domain.model.temperature;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class TemperatureTest extends AbstractJavaBeanTest<Temperature> {

	@Override
	protected Temperature getBeanInstance() {
		return new Temperature();
	}

}
