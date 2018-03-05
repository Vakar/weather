package space.vakar.weather.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.service.api.WeatherService;
import space.vakar.weather.service.impl.WeatherServiceImpl;
import space.vakar.weather.web.mapper.WeatherWebModelMapper;
import space.vakar.weather.web.model.WeatherWebModel;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/weather.do")
public class WeatherServlet extends HttpServlet {

  private static final Logger LOG = Logger.getLogger(WeatherServlet.class);

  private static final long serialVersionUID = 1L;

  private WeatherService weatherService = new WeatherServiceImpl();
  private WeatherWebModelMapper mapper = new WeatherWebModelMapper();


  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String cityId = request.getParameter("cityId");
    Weather weather = null;
    if (cityId != null && cityId.matches("\\d+")) {
      weather = weatherByCityId(cityId);
    }
    if (weather != null) {
      WeatherWebModel weatherModel = mapper.from(weather);
      request.setAttribute("weather", weatherModel);
      request.getRequestDispatcher("/WEB-INF/views/weather.jsp").forward(request, response);
    } else {
      request.getRequestDispatcher("/home.do").forward(request, response);
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

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    doGet(request, response);
  }

}
