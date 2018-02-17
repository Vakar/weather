package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
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
		expected.setValue(new BigDecimal(-1.0));
		expected.setMode("default_mode");
		assertEquals(expected, new Precipitation().defaultInstance());		
	}
}
