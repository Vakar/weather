package space.vakar.weather.ui.jsp.controller;

import org.apache.log4j.Logger;
import space.vakar.weather.domain.api.Cities;
import space.vakar.weather.domain.api.WeatherService;
import space.vakar.weather.domain.impl.CitiesImpl;
import space.vakar.weather.domain.impl.WeatherServiceImpl;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.ui.jsp.mapper.WeatherWebModelMapper;
import space.vakar.weather.ui.jsp.model.WeatherWebModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/** Servlet implementation class WeatherServlet */
@WebServlet("/weather.do")
public class WeatherServlet extends HttpServlet {

  private static final Logger LOG = Logger.getLogger(WeatherServlet.class);

  private static final long serialVersionUID = 1L;

  private static WeatherService weatherService = new WeatherServiceImpl();
  private static WeatherWebModelMapper mapper = new WeatherWebModelMapper();
  private static Cities cities = new CitiesImpl();

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String cityName = request.getParameter("cityName").trim();
    int cityId = cities.getCityIdByName(cityName);
    Weather weather = weatherByCityId(String.valueOf(cityId));
    if(cityId < 0){
      request.setAttribute("status", "Can't find city with name :" + "\"" + cityName + "\"");
      request.getRequestDispatcher("/home.do").forward(request, response);
    } else if( weather == null) {
      request.setAttribute("status", "Can't find weather for city :" + "\"" + cityName + "\"");
      request.getRequestDispatcher("/home.do").forward(request, response);
    } else {
      WeatherWebModel weatherModel = mapper.from(weather);
      request.setAttribute("weather", weatherModel);
      request.getRequestDispatcher("/WEB-INF/views/weather.jsp").forward(request, response);
    }
  }

  private Weather weatherByCityId(String cityId) {
    Weather weather = null;
    try {
      weather = weatherService.weather(Integer.parseInt(cityId));
    } catch (Exception e) {
      LOG.error("Can't get weather from weather service", e);
    }
    return weather;
  }

  /** @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response) */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }
}
