package space.vakar.weather.openweather;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import space.vakar.weather.domain.api.WeatherRetriever;

public class OpenWeatherRetriever implements WeatherRetriever {

	private String serviceUrl = "http://api.openweathermap.org";
	private String weatherEndPoint = "/data/2.5/weather";
	private static final String APPID = "eede123ce615f9cc56910f9a0e024e3a";

	@Override
	public InputStream getWeatherXML(String cityId) throws IOException {
		String url = serviceUrl + weatherEndPoint
					 .concat("?q=" + cityId)
					 .concat("&APPID=" + APPID)
					 .concat("&mode=xml");
		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(new HttpGet(url));
		return response.getEntity().getContent();
	}


	public String getServiceUrl() {
		return serviceUrl;
	}


	public void setServiceUrl(String serviceUrl) {
		this.serviceUrl = serviceUrl;
	}


	public String getWeatherEndPoint() {
		return weatherEndPoint;
	}


	public void setWeatherEndPoint(String weatherEndPoint) {
		this.weatherEndPoint = weatherEndPoint;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((weatherEndPoint == null) ? 0 : weatherEndPoint.hashCode());
		result = prime * result + ((serviceUrl == null) ? 0 : serviceUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OpenWeatherRetriever other = (OpenWeatherRetriever) obj;
		if (weatherEndPoint == null) {
			if (other.weatherEndPoint != null)
				return false;
		} else if (!weatherEndPoint.equals(other.weatherEndPoint))
			return false;
		if (serviceUrl == null) {
			if (other.serviceUrl != null)
				return false;
		} else if (!serviceUrl.equals(other.serviceUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpenWeatherRetriever [openWeatherURL=" + serviceUrl + ", currentWeatherEndPoint="
				+ weatherEndPoint + "]";
	}

}
