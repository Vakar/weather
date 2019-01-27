package space.vakar.weather.open.weather.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class JsonCityReader {

  private static final String CITY_LIST_JSON = "city.list.json";

  public List<CityLocationModel> readCityLocations() throws FileNotFoundException {
    Gson gson = new Gson();
    File file = fileFrom(CITY_LIST_JSON);
    JsonReader reader = new JsonReader(new FileReader(file));
    Type listType = new TypeToken<List<CityLocationModel>>() {}.getType();
    return gson.fromJson(reader, listType);
  }

  private File fileFrom(String path) {
    ClassLoader loader = this.getClass().getClassLoader();
    return new File(loader.getResource(path).getFile());
  }
}
