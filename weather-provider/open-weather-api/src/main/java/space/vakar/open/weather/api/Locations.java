package space.vakar.open.weather.api;

import space.vakar.weather.domain.model.weather.CityLocation;

import java.util.Optional;

public interface Locations {
  Optional<CityLocation> getCityByName(String cityName);
}
