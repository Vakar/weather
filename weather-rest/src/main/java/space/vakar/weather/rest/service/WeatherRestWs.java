package space.vakar.weather.rest.service;

import space.vakar.weather.domain.core.WeatherService;
import space.vakar.weather.domain.core.WeatherServiceImpl;
import space.vakar.weather.domain.model.WeatherDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.CacheControl;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/weather")
public class WeatherRestWs {

  private WeatherService weatherService = new WeatherServiceImpl();

  /**
   * Get weather by city id.
   *
   * @param cityId city id
   * @return current weather for city by city id
   */
  @GET
  @Path("/{cityId}")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getWeatherByCityId(@PathParam("cityId") int cityId) {
    WeatherDto weather = weatherService.weather(cityId).get();
    CacheControl cc = new CacheControl();
    int weatherExpireTime = weatherService.getWeatherExpireTime(weather);
    cc.setMaxAge(weatherExpireTime);
    return Response.ok().entity(weather).cacheControl(cc).build();
  }
}
