package space.vakar.weather.ui.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.domain.api.WeatherService;
import space.vakar.weather.domain.impl.WeatherServiceImpl;
import space.vakar.weather.ui.mapper.WeatherWebModelMapper;
import space.vakar.weather.ui.model.WeatherWebModel;

/** Servlet implementation class WeatherServlet */
@WebServlet("/weather.do")
public class WeatherServlet extends HttpServlet {

  Map<String, String> map;

  private static final Logger LOG = Logger.getLogger(WeatherServlet.class);

  private static final long serialVersionUID = 1L;

  private static WeatherService weatherService = new WeatherServiceImpl();
  private static WeatherWebModelMapper mapper = new WeatherWebModelMapper();

  public WeatherServlet(){
    map = new HashMap<>();
    map.put("Toronto", "6167865");
    map.put("Moncton", "6076211");
    map.put("Kharkiv", "706483");
    map.put("Halifax", "5969423");
  }

  /** @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response) */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    String cityName = request.getParameter("cityName").trim();
    if(cityName.isEmpty()){
      request.setAttribute("status", "You didn't input city name. Pleas input city and try again.");
      request.getRequestDispatcher("/home.do").forward(request, response);
    } else if(isCityExist(cityName)){
      Weather  weather = weatherByCityId(getCityIdByName(cityName));
      if (weather != null) {
        WeatherWebModel weatherModel = mapper.from(weather);
        request.setAttribute("weather", weatherModel);
        request.getRequestDispatcher("/WEB-INF/views/weather.jsp").forward(request, response);
      } else {
        request.setAttribute("status", "Weather not found.");
        request.getRequestDispatcher("/home.do").forward(request, response);
      }
    } else {
      request.setAttribute("status", "City doesn't exist.");
      request.getRequestDispatcher("/home.do").forward(request, response);
    }
  }

  private boolean isCityExist(String cityName){
    return map.containsKey(cityName);
  }

  private String getCityIdByName(String cityName){
    return map.get(cityName);
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
