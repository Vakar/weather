package space.vakar.weather.domain.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;

import org.junit.Test;

import space.vakar.weather.domain.model.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.location.Location;
import space.vakar.weather.domain.model.temperature.Temperature;
import space.vakar.weather.domain.model.wind.Wind;

public class WeatherTest extends AbstractJavaBeanTest<Weather> {

	@Override
	protected Weather getBeanInstance() {
		return new Weather();
	}
	
	@Test
	public void shouldReturnDefaultInstance() {
		Weather expected = new Weather();
		expected.setId(0);
		expected.setWind(new Wind().defaultInstance());
		expected.setAtmosphere(new Atmosphere().defaultInstance());
		expected.setLocation(new Location().defaultInstance());
		expected.setTemperature(new Temperature().defaultInstance());
		expected.setLastUpdate(LocalDateTime.MIN);
		assertEquals(expected, new Weather().defaultInstance());		
	}
}
