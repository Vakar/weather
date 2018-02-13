package space.vakar.weather.domain.model.location;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class SunTest extends AbstractJavaBeanTest<Sun> {

	@Override
	protected Sun getBeanInstance() {
		return new Sun();
	}	
	
	@Test
	public void shouldReturnDefaultInstance() {
		Sun expected = new Sun();
		expected.setId(0);
		expected.setRise(LocalDateTime.MIN);
		expected.setSet(LocalDateTime.MAX);
		assertEquals(expected, new Sun().defaultInstance());		
	}
}
