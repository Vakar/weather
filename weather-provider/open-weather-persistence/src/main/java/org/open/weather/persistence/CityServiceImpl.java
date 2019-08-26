package org.open.weather.persistence;

import java.util.ArrayList;
import java.util.List;
import space.vakar.weather.domain.api.CityService;
import space.vakar.weather.domain.model.City;

public class CityServiceImpl implements CityService {

  private Dao<EntityCity> daoCity = new DaoCity();

  private static final String COLUMN_NAME = "NAME";

  @Override
  public List<City> getCitiesByName(String cityName) {
    List<City> cities = new ArrayList<>();
    try {
      List<EntityCity> entities = daoCity.search(COLUMN_NAME, cityName);
      for (EntityCity enitity : entities) {
        cities.add(ModelConverter.getFrom(enitity));
      }
    } catch (Exception e) {
      throw new OpenWeatherPersistenceException(e.getMessage(), e);
    }
    return cities;
  }

}
