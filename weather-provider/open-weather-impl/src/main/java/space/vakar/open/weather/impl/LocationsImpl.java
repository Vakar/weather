package space.vakar.open.weather.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import space.vakar.open.weather.api.Locations;
import space.vakar.weather.domain.model.weather.CityLocation;

import java.io.File;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

public class LocationsImpl implements Locations {

  private List<CityLocation> cities;

  private static final String CITY_LIST_JSON = "city.list.json";

  public LocationsImpl(){
    cities = readCityLocations();
  }

  @Override
  public Optional<CityLocation> getCityByName(String cityName) {
    return cities.stream()
        .filter(cityLocation -> cityName.equals(cityLocation.getName()))
            .findFirst();
  }

  List<CityLocation> readCityLocations() {
    File file = getCityListJsonFile();
    JsonReader reader;
    try {
      reader = new JsonReader(new FileReader(file));
    } catch (Exception e) {
      throw new OpenWeatherException("Can't read JSON file with cities.", e);
    }
    Type listType = new TypeToken<List<CityLocation>>() {}.getType();
    return new Gson().fromJson(reader, listType);
  }

  private File getCityListJsonFile() {
    ClassLoader loader = this.getClass().getClassLoader();
    return new File(loader.getResource(CITY_LIST_JSON).getFile());
  }
}
