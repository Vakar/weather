package space.vakar.weather.rest.service;

import space.vakar.weather.domain.core.WeatherService;
import space.vakar.weather.domain.core.WeatherServiceImpl;
import space.vakar.weather.domain.model.WeatherDto;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
  public WeatherDto getWeatherByCityId(@PathParam("cityId") int cityId) {
    return weatherService.weather(cityId).get();
  }
}