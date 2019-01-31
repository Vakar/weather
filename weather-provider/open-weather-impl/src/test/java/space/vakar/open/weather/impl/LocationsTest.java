package space.vakar.open.weather.impl;

import org.junit.Before;
import org.junit.Test;
import space.vakar.open.weather.api.Locations;
import space.vakar.weather.domain.model.weather.CityLocation;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

public class LocationsTest {

  private Locations locations = new LocationsImpl();

  private List<CityLocation> expectedCities;

  private CityLocation city1;
  private CityLocation city2;

  private String nameOfExistingCity = "Kathmandu";
  private String nameOfNotExistingCity = "Dnipro";

  @Before
  public void setUp() {
    expectedCities = new ArrayList<>();
    city1 = new CityLocation(1283240, nameOfExistingCity, "NP");
    city2 = new CityLocation(703363, "Laspi", "UA");
    expectedCities.add(city1);
    expectedCities.add(city2);
  }

  @Test
  public void getCityIdByName() {
    Optional<CityLocation> actualCity = locations.getCityByName(nameOfExistingCity);
    assertEquals(Optional.of(city1), actualCity);
    Optional<CityLocation> cityIsNotExist = locations.getCityByName(nameOfNotExistingCity);
    assertFalse(cityIsNotExist.isPresent());
  }

  @Test
  public void readCityLocationFromJsonTest() {
    LocationsImpl locationsImpl = (LocationsImpl) this.locations;
    List<CityLocation> actualCities = locationsImpl.readCityLocations();
    assertEquals(expectedCities, actualCities);
  }
}
