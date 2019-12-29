package space.vakar.open.weather.persistence;

import org.junit.Test;
import space.vakar.weather.domain.model.City;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class CityEntityServiceImpTest {

  private CityServiceImp service = new CityServiceImp();

  private String inputString = "London";

  private City city1 = new City(1,  inputString, "GB");
  private City city2 = new City(2, inputString + "A", "GB");
  private City city3 = new City(3, "A" + inputString, "GB");
  private City city4 = new City(4, "AA" + inputString + "B", "GB");
  private City city5 = new City(5, "AA" + "london", "GB");

  @Test
  public void sortCitiesTest() {
    List<City> unsortedCityList = Arrays.asList(city4, city3, city5, city1, city2);
    List<City> sortedCityList = service.sortCities(inputString, unsortedCityList);
    assertThat(sortedCityList, contains(city1, city2, city3, city4, city5));
  }

  @Test
  public void rankCityTest() {
    assertEquals(0, service.rankCity(inputString, city1));
    assertEquals(1, service.rankCity(inputString, city2));
    assertEquals(2, service.rankCity(inputString, city3));
    assertEquals(3, service.rankCity(inputString, city4));
    assertEquals(3, service.rankCity(inputString, city5));
  }
}
