package space.vakar.weather.domain.model.location;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.location.Sun;

public class SunTest extends AbstractJavaBeanTest<Sun> {

	@Override
	protected Sun getBeanInstance() {
		return new Sun();
	}	
}
