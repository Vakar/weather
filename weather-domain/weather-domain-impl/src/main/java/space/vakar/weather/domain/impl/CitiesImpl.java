package space.vakar.weather.domain.impl;

import space.vakar.open.weather.api.Locations;
import space.vakar.open.weather.impl.LocationsImpl;
import space.vakar.weather.domain.api.Cities;
import space.vakar.weather.domain.model.weather.CityLocation;

import java.util.Optional;

public class CitiesImpl implements Cities {

  private Locations locations;

  public CitiesImpl() {
    locations = new LocationsImpl();
  }

  CitiesImpl(Locations locations) {
    this.locations = locations;
  }

  @Override
  public int getCityIdByName(String cityName) {
    Optional<CityLocation> city = locations.getCityByName(cityName);
    int result = -1;
    if (city.isPresent()) result = city.get().getId();
    return result;
  }
}
