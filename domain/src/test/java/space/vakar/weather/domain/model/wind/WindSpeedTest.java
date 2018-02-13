package space.vakar.weather.domain.model.wind;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class WindSpeedTest extends AbstractJavaBeanTest<WindSpeed> {

	@Override
	protected WindSpeed getBeanInstance() {
		return new WindSpeed();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		WindSpeed expected = new WindSpeed();
		expected.setId(0);
		expected.setValue(Double.NaN);
		expected.setName("default_name");
		assertEquals(expected, new WindSpeed().defaultInstance());		
	}
}
