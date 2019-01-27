package space.vakar.weather.impl;

import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class CityLocationTest {

  private JsonCityReader reader = new JsonCityReader();

  private List<CityLocationModel> expectedModels;

  @Before
  public void setUp() {
    CityLocationModel model = new CityLocationModel();
    model.setId(1283240);
    model.setName("Kathmandu");
    model.setCountry("NP");
    model.setCoord(new Coord("85.316666", "27.716667"));
    expectedModels = new ArrayList<>();
    expectedModels.add(model);
  }

  @Test
  public void readCityLocationFromJsonTest() throws FileNotFoundException {
    List<CityLocationModel> actualModel = reader.readCityLocations();
    assertEquals(expectedModels, actualModel);
  }
}
