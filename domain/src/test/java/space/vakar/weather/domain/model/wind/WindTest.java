package space.vakar.weather.domain.model.wind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.wind.Wind;
import space.vakar.weather.domain.model.impl.wind.WindDirection;
import space.vakar.weather.domain.model.impl.wind.WindSpeed;

public class WindTest extends AbstractJavaBeanTest<Wind>{

	@Override
	protected Wind getBeanInstance() {
		return new Wind();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Wind expected = new Wind();
		expected.setId(0);
		expected.setSpeed(new WindSpeed().defaultInstance());
		expected.setDirection(new WindDirection().defaultInstance());
		assertEquals(expected, new Wind().defaultInstance());		
	}
	
}