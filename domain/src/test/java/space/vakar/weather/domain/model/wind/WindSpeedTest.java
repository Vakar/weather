package space.vakar.weather.domain.model.wind;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;
import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.wind.WindSpeed;

public class WindSpeedTest extends AbstractJavaBeanTest<WindSpeed> {

	@Override
	protected WindSpeed getBeanInstance() {
		return new WindSpeed();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		WindSpeed expected = new WindSpeed();
		expected.setId(0);
		expected.setValue(new BigDecimal(-1.0));
		expected.setName("default_name");
		assertEquals(expected, new WindSpeed().defaultInstance());		
	}
}
