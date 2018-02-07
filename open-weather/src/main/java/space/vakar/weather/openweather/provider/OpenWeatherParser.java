package space.vakar.weather.openweather.provider;

import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import space.vakar.weather.openweather.api.WeatherParser;
import space.vakar.weather.openweather.model.CurrentWeather;

public class OpenWeatherParser implements WeatherParser{

	@Override
	public CurrentWeather parse(InputStream inputStream) throws JAXBException {
		JAXBContext jaxbContext = JAXBContext.newInstance(CurrentWeather.class);	
		Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
		return (CurrentWeather)jaxbUnmarshaller.unmarshal(inputStream);
	}
}
