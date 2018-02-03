package space.vakar.weather.domain.api;

import java.io.IOException;
import java.io.InputStream;

public interface WeatherRetriever {
	public InputStream retrieveCurrantWeatherXML(String cityId) throws IOException;
}
