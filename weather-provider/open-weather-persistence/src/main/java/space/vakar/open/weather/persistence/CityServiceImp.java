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

  private Dao<City> daoCity = new DaoCity();

  private static final String COLUMN_NAME = "NAME";

  private static final int MAX_NUMBER_OF_CITIES = 5;

  @Override
  public List<space.vakar.weather.domain.model.City> getCitiesByName(String cityName) {
    List<space.vakar.weather.domain.model.City> cities;
    try {
      cities = daoCity.search(COLUMN_NAME, cityName);
    } catch (Exception e) {
      throw new OpenWeatherPersistenceException(e.getMessage(), e);
    }
    return sortCities(cityName, cities).stream()
        .limit(MAX_NUMBER_OF_CITIES)
        .collect(Collectors.toList());
  }

  List<space.vakar.weather.domain.model.City> sortCities(String inputString, List<space.vakar.weather.domain.model.City> cityList) {
    List<space.vakar.weather.domain.model.City> sortedList = new ArrayList<>();
    SortedMap<Integer, List<space.vakar.weather.domain.model.City>> citiesByRange = getCitiesByRange(inputString, cityList);
    citiesByRange.forEach(
        (range, cities) -> {
          cities.sort(Comparator.comparing(space.vakar.weather.domain.model.City::getName));
          sortedList.addAll(cities);
        });
    return sortedList;
  }

  SortedMap<Integer, List<space.vakar.weather.domain.model.City>> getCitiesByRange(String inputString, List<space.vakar.weather.domain.model.City> cityList) {
    SortedMap<Integer, List<space.vakar.weather.domain.model.City>> citiesByRange = new TreeMap<>();
    for (space.vakar.weather.domain.model.City city : cityList) {
      int cityRange = rankCity(inputString, city);
      if (!citiesByRange.containsKey(cityRange)) {
        citiesByRange.put(cityRange, new ArrayList<>());
      }
      citiesByRange.get(cityRange).add(city);
    }
    return citiesByRange;
  }

  int rankCity(String inputString, space.vakar.weather.domain.model.City city) {
    String normalizedInputString = inputString.toUpperCase();
    String normalizedCityName = city.getName().toUpperCase();
    int range = normalizedCityName.indexOf(normalizedInputString) + 1;
    if (normalizedCityName.equals(normalizedInputString)) {
      range = 0;
    }
    return range;
  }
}
