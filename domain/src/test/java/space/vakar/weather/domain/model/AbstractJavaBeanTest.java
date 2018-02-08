package space.vakar.weather.domain.model;

import static org.junit.Assert.assertEquals;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;
import org.meanbean.test.BeanTester;
import org.meanbean.lang.Factory;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import space.vakar.weather.domain.model.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.atmosphere.Clouds;
import space.vakar.weather.domain.model.atmosphere.Humidity;
import space.vakar.weather.domain.model.atmosphere.Precipitation;
import space.vakar.weather.domain.model.atmosphere.Pressure;
import space.vakar.weather.domain.model.location.City;
import space.vakar.weather.domain.model.location.Coordinates;
import space.vakar.weather.domain.model.location.Location;
import space.vakar.weather.domain.model.location.Sun;
import space.vakar.weather.domain.model.temperature.Temperature;
import space.vakar.weather.domain.model.temperature.TemperatureUnit;
import space.vakar.weather.domain.model.wind.Wind;
import space.vakar.weather.domain.model.wind.WindDirection;
import space.vakar.weather.domain.model.wind.WindSpeed;

public abstract class AbstractJavaBeanTest<T> {

	@Test
	public void beanShouldBeSerializable() throws Exception {
		final T bean = getBeanInstance();
		final byte[] serBean = SerializationUtils
				.serialize((Serializable) bean);
		@SuppressWarnings("unchecked")
		final T desBean = (T) SerializationUtils.deserialize(serBean);
		assertEquals(bean, desBean);
	}

	@Test
	public void equalsAndHashCodeShouldFollowContract() {
		EqualsVerifier.forClass(getBeanInstance().getClass())
				.suppress(Warning.STRICT_INHERITANCE, Warning.NONFINAL_FIELDS)
				.withRedefinedSuperclass()
				.verify();
	}

	@Test
	public void gettersAndSettersShouldFunctionCorrectly() throws Exception {
		final BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection()
		.addFactory(LocalDateTime.class, new LocalDateTimeFactory());
		beanTester.getFactoryCollection()
		.addFactory(WindSpeed.class, new WindSpeedFactory());
		beanTester.getFactoryCollection()
		.addFactory(WindDirection.class, new WindDirectionFactory());
		beanTester.getFactoryCollection()
		.addFactory(City.class, new CityFactory());		
		beanTester.getFactoryCollection()
		.addFactory(Coordinates.class, new CoordinatesFactory());		
		beanTester.getFactoryCollection()
		.addFactory(Sun.class, new SunFactory());
		beanTester.getFactoryCollection()
		.addFactory(Clouds.class, new CloudsFactory());
		beanTester.getFactoryCollection()
		.addFactory(Humidity.class, new HumidityFactory());
		beanTester.getFactoryCollection()
		.addFactory(Precipitation.class, new PrecipitationFactory());
		beanTester.getFactoryCollection()
		.addFactory(Pressure.class, new PressureFactory());		
		beanTester.getFactoryCollection()		
		.addFactory(Atmosphere.class, new AtmosphereFactory());
		beanTester.getFactoryCollection()
		.addFactory(Location.class, new LocationFactory());
		beanTester.getFactoryCollection()
		.addFactory(Temperature.class, new TemperatureFactory());
		beanTester.getFactoryCollection()		
		.addFactory(Wind.class, new WindFactory());
		beanTester.testBean(getBeanInstance().getClass());
	}

	protected abstract T getBeanInstance();

	class LocalDateTimeFactory implements Factory {

		@Override
		public LocalDateTime create() {
			return LocalDateTime.now();
		}
	}
	
	class WindSpeedFactory implements Factory{
		@Override
		public WindSpeed create() {
			return new WindSpeed(20, "wind");
		}
	}
	
	class WindDirectionFactory implements Factory{
		@Override
		public WindDirection create() {
			return new WindDirection(290, "N", "North");
		}
	}
	
	class CityFactory implements Factory{
		@Override
		public City create() {
			return new City(1, "New York");
		}
	}
	
	class CoordinatesFactory implements Factory{
		@Override
		public Coordinates create() {
			return new Coordinates(-45.7, 58.7);
		}
	}
	
	class SunFactory implements Factory{
		@Override
		public Sun create() {
			LocalDateTime rise = LocalDateTime.parse("2018-02-08T11:31:48");
			LocalDateTime set = LocalDateTime.parse("2018-02-08T11:31:48");
			return new Sun(rise, set);
		}
	}
	
	class CloudsFactory implements Factory{
		@Override
		public Clouds create() {
			return new Clouds(90, "overcast clouds");
		}
	}
	
	class HumidityFactory implements Factory{
		@Override
		public Humidity create() {
			return new Humidity(85, "%");
		}
	}
	
	class PrecipitationFactory implements Factory{
		@Override
		public Precipitation create() {
			return new Precipitation(12.3, "snow");
		}
	}
	
	class PressureFactory implements Factory{
		@Override
		public Pressure create() {
			return new Pressure(1010, "hPa");
		}
	}
	
	class AtmosphereFactory implements Factory{
		@Override
		public Atmosphere create() {
			return new Atmosphere();
		}
	}
	class LocationFactory implements Factory{
		@Override
		public Location create() {
			return new Location();
		}
	}
	class TemperatureFactory implements Factory{
		@Override
		public Temperature create() {
			return new Temperature(200, TemperatureUnit.KELVIN);
		}
	}
	class WindFactory implements Factory{
		@Override
		public Wind create() {
			return new Wind();
		}
	}
}