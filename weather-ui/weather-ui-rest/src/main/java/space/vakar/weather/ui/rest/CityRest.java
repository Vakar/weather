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
public class CityRest {

  private CityService cityService = new CityServiceImpl();

  /**
   * Find cities by name.
   * @param cityName city
   * @return city list with cities like input city name
   */
  @GET
  @Path("/{cityName}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<City> getTestService(@PathParam("cityName") String cityName) {
    return cityService.getCitiesByName(cityName);
  }
}
