package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class AtmosphereTest extends AbstractJavaBeanTest<Atmosphere> {

	@Override
	protected Atmosphere getBeanInstance() {
		return new Atmosphere();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Atmosphere expected = new Atmosphere();
		expected.setId(0);
		expected.setHumidity(new Humidity().defaultInstance());
		expected.setPressure(new Pressure().defaultInstance());
		expected.setVisibility(new BigDecimal(-1.0));
		expected.setPrecipitation(new Precipitation().defaultInstance());
		expected.setClouds(new Clouds().defaultInstance());
		assertEquals(expected, new Atmosphere().defaultInstance());		
	}
}
