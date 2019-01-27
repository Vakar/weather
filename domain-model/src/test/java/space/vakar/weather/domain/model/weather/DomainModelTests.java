package space.vakar.weather.domain.model.weather;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import space.vakar.weather.domain.model.weather.atmosphere.AtmosphereTestsSuite;
import space.vakar.weather.domain.model.weather.location.LocationTestsSuite;
import space.vakar.weather.domain.model.weather.temperature.TemperatureTestsSuite;
import space.vakar.weather.domain.model.weather.wind.WindTestsSuite;

@RunWith(Suite.class)
@Suite.SuiteClasses({WindTestsSuite.class, TemperatureTestsSuite.class, LocationTestsSuite.class,
    AtmosphereTestsSuite.class, ModelTests.class})
public class DomainModelTests {

}
