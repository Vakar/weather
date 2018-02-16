package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class HumidityTest extends AbstractJavaBeanTest<Humidity> {

	@Override
	protected Humidity getBeanInstance() {
		return new Humidity();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Humidity expected = new Humidity();
		expected.setId(0);
		expected.setValue(new BigDecimal(-1.0));
		expected.setUnit("default_unit");
		assertEquals(expected, new Humidity().defaultInstance());		
	}

}
