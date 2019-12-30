package space.vakar.weather.domain.api;

import java.util.List;
import space.vakar.weather.domain.model.City;

public interface CityService {

  /**
   * This method take probable city name and return list of cities with similar name.
   * 
   * @param cityName probable city name
   * @return list of cities
   */
  List<City> findCitiesWithNameLike(String cityName);
}
