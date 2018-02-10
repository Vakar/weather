package space.vakar.weather.provider.openweather;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import space.vakar.weather.provider.openweather.model.CurrentWeather;

class Parser{
	
	private Retriever retriever = new Retriever();

	public CurrentWeather currentWeather(String city) 
			throws JAXBException, IOException {
		InputStream in = retriever.requestCurrentWeatherXML(city);	
		Unmarshaller unmarshaller = createUnmarshaller(CurrentWeather.class);
		return (CurrentWeather)unmarshaller.unmarshal(in);
	}
	
	private Unmarshaller createUnmarshaller(Class<?> clazz) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CurrentWeather.class);	
		return jaxbContext.createUnmarshaller();
	}

	public Retriever getRetriever() {
		return retriever;
	}

	public void setRetriever(Retriever retriever) {
		this.retriever = retriever;
	}
}
