package space.vakar.weather.openweather;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import space.vakar.weather.domain.api.WeatherRetriever;

public class OpenWeatherRetriever implements WeatherRetriever{
	
	private String openWeatherURL = "http://api.openweathermap.org";
	private String currentWeatherEndPoint = "/data/2.5/weather";
	private static final String  APPID = "eede123ce615f9cc56910f9a0e024e3a";

	@Override
	public InputStream retrieveCurrantWeatherXML(String cityId) throws IOException {
		String url = openWeatherURL + currentWeatherEndPoint
				.concat("?q=" + cityId)
				.concat("&APPID="+APPID)
				.concat("&mode=xml");
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(url);
		HttpResponse response = client.execute(request);
		return response.getEntity().getContent();
	}

	public String getOpenWeatherURL() {
		return openWeatherURL;
	}

	public void setOpenWeatherURL(String openWeatherURL) {
		this.openWeatherURL = openWeatherURL;
	}

	public String getCurrentWeatherEndPoint() {
		return currentWeatherEndPoint;
	}

	public void setCurrentWeatherEndPoint(String currentWeatherEndPoint) {
		this.currentWeatherEndPoint = currentWeatherEndPoint;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((currentWeatherEndPoint == null) ? 0 : currentWeatherEndPoint.hashCode());
		result = prime * result + ((openWeatherURL == null) ? 0 : openWeatherURL.hashCode());
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
		if (currentWeatherEndPoint == null) {
			if (other.currentWeatherEndPoint != null)
				return false;
		} else if (!currentWeatherEndPoint.equals(other.currentWeatherEndPoint))
			return false;
		if (openWeatherURL == null) {
			if (other.openWeatherURL != null)
				return false;
		} else if (!openWeatherURL.equals(other.openWeatherURL))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OpenWeatherRetriever [openWeatherURL=" + openWeatherURL + ", currentWeatherEndPoint="
				+ currentWeatherEndPoint + "]";
	}	
	
}
