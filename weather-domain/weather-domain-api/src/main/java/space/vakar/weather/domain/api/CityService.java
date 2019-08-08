package space.vakar.weather.domain.api;

import java.util.List;

import space.vakar.weather.domain.model.City;

public interface CityService {

	List<City> getCitiesByName(String cityName);
}
