package space.vakar.weather.domain.model.atmosphere;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;

public class CloudsTest extends AbstractJavaBeanTest<Clouds> {

	@Override
	protected Clouds getBeanInstance() {
		return new Clouds();
	}	
	
	@Test
	public void shouldReturnDefaultInstance() {
		Clouds expected = new Clouds();
		expected.setId(0);
		expected.setValue(Double.NaN);
		expected.setName("default_name");
		assertEquals(expected, new Clouds().defaultInstance());		
	}
}
