package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class PressureTest extends AbstractJavaBeanTest<Pressure> {

	@Override
	protected Pressure getBeanInstance() {
		return new Pressure();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Pressure expected = new Pressure();
		expected.setId(0);
		expected.setValue(Double.NaN);
		expected.setUnit("default_unit");
		assertEquals(expected, new Pressure().defaultInstance());		
	}
}
