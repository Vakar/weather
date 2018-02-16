package space.vakar.weather.domain.model.temperature;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
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
		expected.setValue(new BigDecimal(-1.0));
		expected.setUnit(TemperatureUnit.UNIT_UNKNOWN);
		assertEquals(expected, new Temperature().defaultInstance());		
	}

}
