package space.vakar.open.weather.persistence;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import space.vakar.weather.domain.model.City;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CityEntityServiceImpTest {

  private final CityServiceImp service = new CityServiceImp();

  private static final String CITY_NAME = "London";

  private final City city1 = new City(1, CITY_NAME, "GB");
  private final City city2 = new City(2, CITY_NAME + "A", "GB");
  private final City city3 = new City(3, "A" + CITY_NAME, "GB");
  private final City city4 = new City(4, "AA" + CITY_NAME + "B", "GB");
  private final City city5 = new City(5, "AA" + "london", "GB");

  @Nested
  @DisplayName("run sortCityList method")
  class SortCities {

    @Test
    @DisplayName("when take valid city name & unsorted city list")
    public void sortCitiesTest() {
      List<City> unsortedCityList = Arrays.asList(city4, city3, city5, city1, city2);
      List<City> actualCityList = service.sortCityList(CITY_NAME, unsortedCityList);
      List<City> sortedCityList = Arrays.asList(city1, city2, city3, city4, city5);
      assertIterableEquals(sortedCityList, actualCityList, "should return sorted city list");
    }
  }

  @Nested
  @DisplayName("run rankCity method")
  class RankCity {

    @Test
    @DisplayName("when take valid city name & city object")
    public void rankCityTest() {
      assertAll(
          "should rank city objects properly",
          () -> assertEquals(0, service.rankCity(CITY_NAME, city1)),
          () -> assertEquals(1, service.rankCity(CITY_NAME, city2)),
          () -> assertEquals(2, service.rankCity(CITY_NAME, city3)),
          () -> assertEquals(3, service.rankCity(CITY_NAME, city4)),
          () -> assertEquals(3, service.rankCity(CITY_NAME, city5)));
    }
  }
}
