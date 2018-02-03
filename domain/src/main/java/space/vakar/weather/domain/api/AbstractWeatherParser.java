package space.vakar.weather.domain.api;

import java.io.InputStream;

public abstract class AbstractWeatherParser implements WeatherParser {
	
	private InputStream inputStream;

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
}
