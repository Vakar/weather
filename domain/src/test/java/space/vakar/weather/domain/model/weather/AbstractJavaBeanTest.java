package space.vakar.weather.domain.model.weather;

import static org.junit.Assert.assertEquals;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.apache.commons.lang.SerializationUtils;
import org.junit.Test;
import org.meanbean.lang.Factory;
import org.meanbean.test.BeanTester;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import space.vakar.weather.domain.model.weather.atmosphere.Atmosphere;
import space.vakar.weather.domain.model.weather.atmosphere.CloudinessUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Clouds;
import space.vakar.weather.domain.model.weather.atmosphere.Humidity;
import space.vakar.weather.domain.model.weather.atmosphere.HumidityUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Precipitation;
import space.vakar.weather.domain.model.weather.atmosphere.PrecipitationUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Pressure;
import space.vakar.weather.domain.model.weather.atmosphere.PressureUnit;
import space.vakar.weather.domain.model.weather.atmosphere.Visibility;
import space.vakar.weather.domain.model.weather.atmosphere.VisibilityUnit;
import space.vakar.weather.domain.model.weather.location.City;
import space.vakar.weather.domain.model.weather.location.Coordinates;
import space.vakar.weather.domain.model.weather.location.Location;
import space.vakar.weather.domain.model.weather.location.Sun;
import space.vakar.weather.domain.model.weather.temperature.Temperature;
import space.vakar.weather.domain.model.weather.temperature.TemperatureUnit;
import space.vakar.weather.domain.model.weather.wind.SpeedUnit;
import space.vakar.weather.domain.model.weather.wind.Wind;
import space.vakar.weather.domain.model.weather.wind.WindDirection;
import space.vakar.weather.domain.model.weather.wind.WindSpeed;

public abstract class AbstractJavaBeanTest<T> {

  @Test
  public void beanShouldBeSerializable() throws Exception {
    final T bean = getBeanInstance();
    final byte[] serBean = SerializationUtils.serialize((Serializable) bean);
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
    beanTester.getFactoryCollection().addFactory(LocalDateTime.class, new LocalDateTimeFactory());
    beanTester.getFactoryCollection().addFactory(WindSpeed.class, new WindSpeedFactory());
    beanTester.getFactoryCollection().addFactory(WindDirection.class, new WindDirectionFactory());
    beanTester.getFactoryCollection().addFactory(City.class, new CityFactory());
    beanTester.getFactoryCollection().addFactory(Coordinates.class, new CoordinatesFactory());
    beanTester.getFactoryCollection().addFactory(Sun.class, new SunFactory());
    beanTester.getFactoryCollection().addFactory(Clouds.class, new CloudsFactory());
    beanTester.getFactoryCollection().addFactory(Humidity.class, new HumidityFactory());
    beanTester.getFactoryCollection().addFactory(Precipitation.class, new PrecipitationFactory());
    beanTester.getFactoryCollection().addFactory(Pressure.class, new PressureFactory());
    beanTester.getFactoryCollection().addFactory(Visibility.class, new VisibilityFactory());
    beanTester.getFactoryCollection().addFactory(Atmosphere.class, new AtmosphereFactory());
    beanTester.getFactoryCollection().addFactory(Location.class, new LocationFactory());
    beanTester.getFactoryCollection().addFactory(Temperature.class, new TemperatureFactory());
    beanTester.getFactoryCollection().addFactory(Wind.class, new WindFactory());
    beanTester.getFactoryCollection().addFactory(CityLocation.class, new CityLocationFactory());
    beanTester.testBean(getBeanInstance().getClass());
  }

  protected abstract T getBeanInstance();

  class LocalDateTimeFactory implements Factory<LocalDateTime> {

    @Override
    public LocalDateTime create() {
      return LocalDateTime.now();
    }
  }

  class WindSpeedFactory implements Factory<WindSpeed> {
    @Override
    public WindSpeed create() {
      return new WindSpeed(new BigDecimal(20), SpeedUnit.MILES_PER_HOUR, "wind");
    }
  }

  class WindDirectionFactory implements Factory<WindDirection> {
    @Override
    public WindDirection create() {
      return new WindDirection(new BigDecimal(290), "N", "North");
    }
  }

  class CityFactory implements Factory<City> {
    @Override
    public City create() {
      return new City(1, "New York");
    }
  }

  class CoordinatesFactory implements Factory<Coordinates> {
    @Override
    public Coordinates create() {
      return new Coordinates(new BigDecimal(-45.7), new BigDecimal(58.7));
    }
  }

  class SunFactory implements Factory<Sun> {
    @Override
    public Sun create() {
      LocalDateTime rise = LocalDateTime.parse("2018-02-08T11:31:48");
      LocalDateTime set = LocalDateTime.parse("2018-02-08T11:31:48");
      return new Sun(rise, set);
    }
  }

  class CloudsFactory implements Factory<Clouds> {
    @Override
    public Clouds create() {
      return new Clouds(new BigDecimal(1), CloudinessUnit.PERCENTAGE_OF_SKY_AREA, "Clean Sky");
    }
  }

  class HumidityFactory implements Factory<Humidity> {
    @Override
    public Humidity create() {
      return new Humidity(new BigDecimal(85), HumidityUnit.RELATIVE_HUMIDITY);
    }
  }

  class PrecipitationFactory implements Factory<Precipitation> {
    @Override
    public Precipitation create() {
      return new Precipitation(new BigDecimal(12.3), PrecipitationUnit.MILLIMETRE, "snow");
    }
  }

  class PressureFactory implements Factory<Pressure> {
    @Override
    public Pressure create() {
      return new Pressure(new BigDecimal(1010), PressureUnit.MILLIMETER_OF_MERCURY);
    }
  }

  class VisibilityFactory implements Factory<Visibility> {
    @Override
    public Visibility create() {
      return new Visibility(new BigDecimal(1), VisibilityUnit.METER);
    }
  }

  class AtmosphereFactory implements Factory<Atmosphere> {
    @Override
    public Atmosphere create() {
      return new Atmosphere();
    }
  }

  class LocationFactory implements Factory<Location> {
    @Override
    public Location create() {
      return new Location();
    }
  }

  class TemperatureFactory implements Factory<Temperature> {
    @Override
    public Temperature create() {
      return new Temperature(new BigDecimal(200), TemperatureUnit.KELVIN);
    }
  }

  class WindFactory implements Factory<Wind> {
    @Override
    public Wind create() {
      return new Wind();
    }
  }

  class CityLocationFactory implements Factory<CityLocation> {
    @Override
    public CityLocation create() {
      return new CityLocation();
    }
  }
}
