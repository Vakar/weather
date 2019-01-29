package space.vakar.open.weather.impl;

import org.junit.Before;
import org.junit.Test;
import space.vakar.weather.domain.api.Locations;
import space.vakar.weather.domain.model.location.CityLocation;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CityLocationTest {

  private Locations locations = new LocationsImpl();

  private List<CityLocation> expectedCities;

  private CityLocation city1;
  private CityLocation city2;

  private String cityName = "Kathmandu";

  @Before
  public void setUp() {
    expectedCities = new ArrayList<>();
    city1 = new CityLocation(1283240, cityName, "NP");
    city2 = new CityLocation(703363, "Laspi", "UA");
    expectedCities.add(city1);
    expectedCities.add(city2);
  }

  @Test
  public void getCitiesByNameTest() {
    List<CityLocation> expectedCitiesByName = new ArrayList<>();
    expectedCitiesByName.add(city1);
    List<CityLocation> actualCities = locations.getCitiesByName(cityName);
    assertEquals(expectedCitiesByName, actualCities);
  }

  @Test
  public void readCityLocationFromJsonTest() {
    LocationsImpl locationsImpl = (LocationsImpl) this.locations;
    List<CityLocation> actualCities = locationsImpl.readCityLocations();
    assertEquals(expectedCities, actualCities);
  }
}
