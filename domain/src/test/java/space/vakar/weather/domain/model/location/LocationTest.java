package space.vakar.weather.domain.model.location;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class LocationTest extends AbstractJavaBeanTest<Location> {

	@Override
	protected Location getBeanInstance() {
		return new Location();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Location expected = new Location();
		expected.setCoordinates(new Coordinates());
		expected.setSun(new Sun().defaultInstance());
		expected.setCity(new City().defaultInstance());
		expected.setCountry("default_country");
		assertEquals(expected, new Location().defaultInstance());		
	}
}
