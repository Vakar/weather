package space.vakar.open.weather.persistence;

import space.vakar.weather.domain.api.CityService;
import space.vakar.weather.domain.model.City;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CityServiceImp implements CityService {

  private Dao<City> cityDao = new CityDao();

  private static final String COLUMN_NAME = "NAME";
  private static final int MAX_NUMBER_OF_CITIES = 5;

  @Override
  public List<City> findCitiesWithNameLike(String cityName) {
    List<City> cityList;
    try {
      cityList = cityDao.search(COLUMN_NAME, cityName);
    } catch (Exception e) {
      throw new DatasourceException(e.getMessage(), e);
    }
    return sortCityList(cityName, cityList).stream()
        .limit(MAX_NUMBER_OF_CITIES)
        .collect(Collectors.toList());
  }

  List<City> sortCityList(String cityName, List<City> cityList) {
    List<City> sortedList = new ArrayList<>();
    SortedMap<Integer, List<City>> citiesByRange = getCitiesByRange(cityName, cityList);
    citiesByRange.forEach(
        (range, cities) -> {
          cities.sort(Comparator.comparing(City::getName));
          sortedList.addAll(cities);
        });
    return sortedList;
  }

  SortedMap<Integer, List<City>> getCitiesByRange(String inputString, List<City> cityList) {
    SortedMap<Integer, List<City>> citiesByRange = new TreeMap<>();
    for (City city : cityList) {
      int cityRange = rankCity(inputString, city);
      if (!citiesByRange.containsKey(cityRange)) {
        citiesByRange.put(cityRange, new ArrayList<>());
      }
      citiesByRange.get(cityRange).add(city);
    }
    return citiesByRange;
  }

  int rankCity(String inputString, City city) {
    String normalizedInputString = inputString.toUpperCase();
    String normalizedCityName = city.getName().toUpperCase();
    int range = normalizedCityName.indexOf(normalizedInputString) + 1;
    if (normalizedCityName.equals(normalizedInputString)) {
      range = 0;
    }
    return range;
  }
}
