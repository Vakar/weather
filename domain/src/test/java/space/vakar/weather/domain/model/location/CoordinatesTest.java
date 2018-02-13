package space.vakar.weather.domain.model.location;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class CoordinatesTest extends AbstractJavaBeanTest<Coordinates> {

	@Override
	protected Coordinates getBeanInstance() {
		return new Coordinates();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Coordinates expected = new Coordinates();
		expected.setId(0);
		expected.setLongitude(Double.NaN);
		expected.setLatitude(Double.NaN);
		assertEquals(expected, new Coordinates().defaultInstance());		
	}

}
