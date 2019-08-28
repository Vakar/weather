package space.vakar.open.weather.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import space.vakar.open.weather.persistence.EntityCity;
import space.vakar.open.weather.persistence.ModelConverter;
import space.vakar.weather.domain.model.City;

public class ModelConverterTest {

  @Test
  public void cityConvertTest() {
    EntityCity entity = new EntityCity(1, "Monaco", "FR");
    City expectedCity = new City(1, "Monaco", "FR");
    City actualCity = ModelConverter.getFrom(entity);
    assertEquals(expectedCity, actualCity);
  }

}
