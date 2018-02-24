package space.vakar.weather.domain.model.atmosphere;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.atmosphere.Humidity;

public class HumidityTest extends AbstractJavaBeanTest<Humidity> {

	@Override
	protected Humidity getBeanInstance() {
		return new Humidity();
	}
}
