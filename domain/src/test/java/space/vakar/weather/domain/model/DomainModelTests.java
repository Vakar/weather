package space.vakar.weather.domain.model;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import space.vakar.weather.domain.model.atmosphere.AtmosphereTestsSuite;
import space.vakar.weather.domain.model.location.LocationTestsSuite;
import space.vakar.weather.domain.model.temperature.TemperatureTestsSuite;
import space.vakar.weather.domain.model.wind.WindTestsSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	WindTestsSuite.class,
	TemperatureTestsSuite.class,
	LocationTestsSuite.class,
	AtmosphereTestsSuite.class,
	ModelTests.class
})
public class DomainModelTests {

}
