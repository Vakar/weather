package space.vakar.weather.ui.rest;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.open.weather.persistence.CityServiceImpl;
import space.vakar.weather.domain.api.CityService;
import space.vakar.weather.domain.model.City;

@Path("/city")
public class CityRestWs {

  private CityService cityService = new CityServiceImpl();

  /**
   * Find cities by input substring. Result contains city names witch contains input substring.
   * 
   * @param inputSubstring substring that represent supposed city name
   * @return city names witch contains input substring
   */
  @GET
  @Path("/getCitiesByName/{inputSubstring}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<City> getCitiesByName(@PathParam("inputSubstring") String inputSubstring) {
    return cityService.getCitiesByName(inputSubstring);
  }
}
