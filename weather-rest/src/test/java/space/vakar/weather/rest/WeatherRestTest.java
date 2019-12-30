package space.vakar.weather.rest;

import static org.junit.Assert.assertEquals;

import io.github.benas.randombeans.api.EnhancedRandom;
import java.util.Optional;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.apache.http.entity.ContentType;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import space.vakar.weather.domain.core.WeatherService;
import space.vakar.weather.domain.model.WeatherDto;
import space.vakar.weather.rest.service.WeatherRestWs;

public class WeatherRestTest extends JerseyTest {

  @Mock
  private WeatherService service;

  @InjectMocks
  private WeatherRestWs rest;

  private WeatherDto weather = EnhancedRandom.random(WeatherDto.class);

  private static final String GET_WEATHER_BY_CITY_PATH = "/weather/";
  private static final int CITY_ID = 1;

  @Override
  protected Application configure() {
    MockitoAnnotations.initMocks(this);
    return new ResourceConfig().register(rest);
  }

  @Test
  public void returnHttpStatusOk_whenCorrectRequest() {
    Mockito.when(service.findWeatherForCityWithId(CITY_ID)).thenReturn(Optional.ofNullable(weather));
    Response response = target(GET_WEATHER_BY_CITY_PATH + CITY_ID).request().get();
    assertEquals("Http Response should be 200: ", Status.OK.getStatusCode(), response.getStatus());
  }

  @Test
  public void returnApplicationJson_whenCorrectRequest() {
    Mockito.when(service.findWeatherForCityWithId(CITY_ID)).thenReturn(Optional.ofNullable(weather));
    Response response = target(GET_WEATHER_BY_CITY_PATH + CITY_ID).request().get();
    assertEquals("Content type should be application/json: ",
        ContentType.APPLICATION_JSON.getMimeType(), response.getHeaderString("Content-Type"));
  }

  @Test
  public void returnCorrectEntity_whenCorrectRequest() {
    Mockito.when(service.findWeatherForCityWithId(CITY_ID)).thenReturn(Optional.ofNullable(weather));
    WeatherDto actualWeather =
        target(GET_WEATHER_BY_CITY_PATH + CITY_ID).request().get(WeatherDto.class);
    assertEquals("Should return entity with the same fields: ", weather, actualWeather);
  }

}
