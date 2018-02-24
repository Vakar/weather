package space.vakar.weather.domain.model.wind;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.wind.WindDirection;

public class WindDirectionTest extends AbstractJavaBeanTest<WindDirection>{

	@Override
	protected WindDirection getBeanInstance() {
		return new WindDirection();
	}
}
