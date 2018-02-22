package space.vakar.weather.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.WeatherService;
import space.vakar.weather.service.impl.WeatherServiceImpl;
import space.vakar.weather.web.mapper.WeatherWebModelMapper;
import space.vakar.weather.web.model.WeatherWebModel;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/weather.do")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	WeatherService weatherService = new WeatherServiceImpl();
	WeatherWebModelMapper mapper = new WeatherWebModelMapper();


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Weather weather = weatherService.weather(6076211);
	  WeatherWebModel weatherModel = mapper.from(weather);	  
	  System.out.println(weatherModel);
	  request.setAttribute("weather", weatherModel);
	  request.getRequestDispatcher("/WEB-INF/views/weather.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
