package space.vakar.weather.domain.model.atmosphere;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AtmosphereTest.class, CloudsTest.class, HumidityTest.class,
		PrecipitationTest.class, PressureTest.class })
public class AtmosphereTestsSuite {

}
