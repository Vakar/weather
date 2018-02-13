package space.vakar.weather.provider.openweather;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import space.vakar.weather.provider.openweather.api.WeatherParser;
import space.vakar.weather.provider.openweather.api.WeatherRetriever;
import space.vakar.weather.provider.openweather.model.CurrentWeather;

class Parser implements WeatherParser{
	
	private WeatherRetriever retriever = new Retriever();

	public CurrentWeather weather(int cityId) 
			throws JAXBException, IOException {
		InputStream in = retriever.weatherXML(cityId);	
		Unmarshaller unmarshaller = createUnmarshaller(CurrentWeather.class);
		return (CurrentWeather)unmarshaller.unmarshal(in);
	}
	
	private Unmarshaller createUnmarshaller(Class<?> clazz) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CurrentWeather.class);	
		return jaxbContext.createUnmarshaller();
	}

	public WeatherRetriever getRetriever() {
		return retriever;
	}

	public void setRetriever(WeatherRetriever retriever) {
		this.retriever = retriever;
	}
}
