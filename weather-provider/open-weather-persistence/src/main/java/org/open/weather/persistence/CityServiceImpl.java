package org.open.weather.persistence;

import java.util.ArrayList;
import java.util.List;

import space.vakar.weather.domain.api.CityService;
import space.vakar.weather.domain.model.City;

public class CityServiceImpl implements CityService {

	private Dao<DtoCity> dao = new DaoCity();

	private static final String COLUMN_NAME = "NAME";

	@Override
	public List<City> getCitiesByName(String cityName) {
		List<City> cities = new ArrayList<>();
		try {
			List<DtoCity> dtos = dao.search(COLUMN_NAME, cityName);
			for (DtoCity dtoCity : dtos) {
				cities.add(CityConverter.convert(dtoCity));
			}
		} catch (Exception e) {
			throw new OpenWeatherPersistenceException(e.getMessage(), e);
		}
		return cities;
	}

}
