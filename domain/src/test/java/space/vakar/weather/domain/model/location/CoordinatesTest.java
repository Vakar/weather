package space.vakar.weather.domain.model.location;

import static org.junit.Assert.assertEquals;
import java.math.BigDecimal;
import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.location.Coordinates;

public class CoordinatesTest extends AbstractJavaBeanTest<Coordinates> {

	@Override
	protected Coordinates getBeanInstance() {
		return new Coordinates();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Coordinates expected = new Coordinates();
		expected.setId(0);
		expected.setLongitude(new BigDecimal(-1.0));
		expected.setLatitude(new BigDecimal(-1.0));
		assertEquals(expected, new Coordinates().defaultInstance());		
	}

}
