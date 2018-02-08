package space.vakar.weather.domain.model.wind;

import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.test.EqualsMethodTester;
import org.meanbean.test.HashCodeMethodTester;

public class WindTest {

	@Test
	public void gettersAndSettersShouldFunctionCorrectly() {
		BeanTester tester = new BeanTester();
		tester.testBean(Wind.class);
	}

	@Test
	public void hashCodeShouldFunctionCorrectly() {
		HashCodeMethodTester tester = new HashCodeMethodTester();
		tester.testHashCodeMethod(Wind.class);
	}

	@Test
	public void equalsShouldFunctionCorrectly() {
		EqualsMethodTester tester = new EqualsMethodTester();
		tester.testEqualsMethod(Wind.class);
	}
}
