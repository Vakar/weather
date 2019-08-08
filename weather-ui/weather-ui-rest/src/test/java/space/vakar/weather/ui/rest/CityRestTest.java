package space.vakar.weather.ui.rest;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
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

import space.vakar.weather.domain.api.CityService;
import space.vakar.weather.domain.model.City;

public class CityRestTest extends JerseyTest {

	@Mock
	private CityService service;

	@InjectMocks
	private CityRest rest;

	private City city = new City(1, "Monaco", "FR");
	private List<City> cities = Collections.singletonList(city);

	private static final String PATH = "/city/";
	private static final String CITY_NAME = "Monaco";

	@Override
	protected Application configure() {
		MockitoAnnotations.initMocks(this);
		return new ResourceConfig().register(rest);
	}

	@Test
	public void returnHttpStatusOk_whenCorrectRequest() {
		Mockito.when(service.getCitiesByName(CITY_NAME)).thenReturn(cities);
		Response response = target(PATH + CITY_NAME).request().get();
		assertEquals("Http Response should be 200: ", Status.OK.getStatusCode(), response.getStatus());
	}

	@Test
	public void returnApplicationJson_whenCorrectRequest() {
		Mockito.when(service.getCitiesByName(CITY_NAME)).thenReturn(cities);
		Response response = target(PATH + CITY_NAME).request().get();
		assertEquals("Content type should be application/json: ", ContentType.APPLICATION_JSON.getMimeType(),
				response.getHeaderString("Content-Type"));
	}

	@Test
	public void returnCorrectEntity_whenCorrectRequest() {
		Mockito.when(service.getCitiesByName(CITY_NAME)).thenReturn(cities);
		List<City> actualCity = target(PATH + CITY_NAME).request().get(new GenericType<List<City>>() {
		});
		assertEquals("Should return entity with the same fields: ", cities, actualCity);
	}

}
