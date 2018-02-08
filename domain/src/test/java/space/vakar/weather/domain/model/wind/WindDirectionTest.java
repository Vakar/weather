package space.vakar.weather.domain.model.wind;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class WindDirectionTest extends AbstractJavaBeanTest<WindDirection>{

	@Override
	protected WindDirection getBeanInstance() {
		return new WindDirection();
	}

}
