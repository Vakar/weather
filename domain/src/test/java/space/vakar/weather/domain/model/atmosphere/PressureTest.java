package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.atmosphere.Pressure;

public class PressureTest extends AbstractJavaBeanTest<Pressure> {

	@Override
	protected Pressure getBeanInstance() {
		return new Pressure();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Pressure expected = new Pressure();
		expected.setId(0);
		expected.setValue(new BigDecimal(-1.0));
		expected.setUnit("default_unit");
		assertEquals(expected, new Pressure().defaultInstance());		
	}
}
