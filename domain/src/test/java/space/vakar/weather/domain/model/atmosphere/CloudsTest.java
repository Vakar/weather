package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.atmosphere.Clouds;

public class CloudsTest extends AbstractJavaBeanTest<Clouds> {

	@Override
	protected Clouds getBeanInstance() {
		return new Clouds();
	}	
	
	@Test
	public void shouldReturnDefaultInstance() {
		Clouds expected = new Clouds();
		expected.setId(0);
		expected.setValue(new BigDecimal(-1.0));
		expected.setName("default_name");
		assertEquals(expected, new Clouds().defaultInstance());		
	}
}
