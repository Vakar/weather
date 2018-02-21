package space.vakar.weather.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import space.vakar.weather.web.model.WeatherWebModel;
import space.vakar.weather.web.service.TempWeatherService;

/**
 * Servlet implementation class WeatherServlet
 */
@WebServlet("/weather.do")
public class WeatherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	TempWeatherService service = new TempWeatherService();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WeatherServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  WeatherWebModel weatherModel = service.weather();
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
