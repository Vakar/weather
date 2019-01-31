package space.vakar.weather.domain.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import space.vakar.open.weather.api.Locations;
import space.vakar.weather.domain.api.Cities;
import space.vakar.weather.domain.model.weather.CityLocation;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CitiesImplTest {

  private Cities cities;

  private CityLocation city;
  private int cityId;
  private String cityName = "cityName";

  @Mock private Locations locations;

  @Before
  public void setUp() {
    cities = new CitiesImpl(locations);
    cityId = 1;
    city = new CityLocation(cityId, cityName, "county");
  }

  @Test
  public void getCityIdByName() {
    when(locations.getCityByName(cityName)).thenReturn(Optional.of(city));
    int actual = cities.getCityIdByName(cityName);
    assertEquals(cityId, actual);
  }
}
