package space.vakar.weather.provider.openweather;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import space.vakar.weather.provider.openweather.model.CurrentWeather;

class Parser{

	public static CurrentWeather parse(InputStream inputStream) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CurrentWeather.class);	
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (CurrentWeather)jaxbUnmarshaller.unmarshal(inputStream);
	}
}
