package space.vakar.weather.rest.service;

import space.vakar.open.weather.persistence.CityServiceImp;
import space.vakar.weather.domain.api.CityService;
import space.vakar.weather.domain.model.City;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/city")
public class CityRestWs {

  private CityService cityService = new CityServiceImp();

  /**
   * Find cities by input substring. Result contains city names witch contains input substring.
   *
   * @param cityName substring that represent supposed city name
   * @return city names witch contains input substring
   */
  @GET
  @Path("/{cityName}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<City> getCitiesByName(@PathParam("cityName") String cityName) {
    return cityService.getCitiesByName(cityName);
  }
}
