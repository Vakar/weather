package space.vakar.weather.provider.openweather;

import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import space.vakar.weather.provider.openweather.api.WeatherRetriever;

import java.util.Objects;

class Retriever implements WeatherRetriever {

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
		return Objects.hash(serviceUrl, weatherEndPoint);
	}


	@Override
	public boolean equals(Object object) {
		if (object instanceof Retriever) {
			Retriever that = (Retriever) object;
			return Objects.equals(this.serviceUrl, that.serviceUrl)
					&& Objects.equals(this.weatherEndPoint, that.weatherEndPoint);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "OpenWeatherRetriever [serviceUrl=%s, weatherEndPoint=%s]";
		return String.format(format, serviceUrl, weatherEndPoint);
	}
}
