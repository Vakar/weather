package space.vakar.weather.domain.model.temperature;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class TemperatureTest extends AbstractJavaBeanTest<Temperature> {

	@Override
	protected Temperature getBeanInstance() {
		return new Temperature();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Temperature expected = new Temperature();
		expected.setId(0);
		expected.setValue(Double.NaN);
		expected.setUnit(TemperatureUnit.UNIT_UNKNOWN);
		assertEquals(expected, new Temperature().defaultInstance());		
	}

}
