package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class PrecipitationTest extends AbstractJavaBeanTest<Precipitation> {

	@Override
	protected Precipitation getBeanInstance() {
		return new Precipitation();
	}

	@Test
	public void shouldReturnDefaultInstance() {
		Precipitation expected = new Precipitation();
		expected.setId(0);
		expected.setValue(Double.NaN);
		expected.setMode("default_mode");
		assertEquals(expected, new Precipitation().defaultInstance());		
	}
}
