package space.vakar.weather.api;

import space.vakar.weather.domain.model.location.CityLocation;

import java.util.List;

public interface Locations {
    List<CityLocation> getCitiesByName(String cityName);
}
