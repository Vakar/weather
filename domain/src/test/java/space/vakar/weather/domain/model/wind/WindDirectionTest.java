package space.vakar.weather.domain.model.wind;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;
import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class WindDirectionTest extends AbstractJavaBeanTest<WindDirection>{

	@Override
	protected WindDirection getBeanInstance() {
		return new WindDirection();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		WindDirection expected = new WindDirection();
		expected.setId(0);
		expected.setValue(new BigDecimal(-1.0));
		expected.setCode("default_code");
		expected.setName("default_name");
		assertEquals(expected, new WindDirection().defaultInstance());		
	}
}
