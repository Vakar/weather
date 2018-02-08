package space.vakar.weather.domain.model.wind;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class WindTest extends AbstractJavaBeanTest<Wind>{

	@Override
	protected Wind getBeanInstance() {
		return new Wind();
	}
	
}