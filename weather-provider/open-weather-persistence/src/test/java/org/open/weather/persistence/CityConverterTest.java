package org.open.weather.persistence;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import space.vakar.weather.domain.model.City;

public class CityConverterTest {

  @Test
  public void convertTest() {
    DtoCity dto = new DtoCity(1, "Monaco", "FR");
    City expectedCity = new City(1, "Monaco", "FR");
    City actualCity = CityConverter.convert(dto);
    assertEquals(expectedCity, actualCity);
  }

}
