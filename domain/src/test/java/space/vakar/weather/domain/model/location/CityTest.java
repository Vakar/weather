package space.vakar.weather.domain.model.location;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.location.City;

public class CityTest extends AbstractJavaBeanTest<City> {

	@Override
	protected City getBeanInstance() {
		return new City();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		City expected = new City();
		expected.setId(0);
		expected.setName("default_name");
		assertEquals(expected, new City().defaultInstance());		
	}
}
