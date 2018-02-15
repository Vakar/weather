package space.vakar.weather.provider.openweather.api;

import java.io.IOException;

import javax.xml.bind.JAXBException;
import org.xml.sax.SAXException;
import space.vakar.weather.provider.openweather.model.CurrentWeather;

/**
 * A set of methods for parsing weather from OpenWeather source to {@link CurrentWeather}.
 */
public interface WeatherParser {
	
	/**
	 * Unmarshal OpenWeather current weather from XML to {@link CurrentWeather} 
	 * using JAXB with schema validation
	 * @param cityId special OpenWeather unique city id
	 * @return {@link CurrentWeather} instance with data about current weather
	 * @throws JAXBException if an error was encountered while creating the <tt>JAXBContext</tt>
	 * @throws IOException in case of a connection problem or the connection was aborted
	 * @throws SAXException in case when can't parse validation schema properly
	 */
	public CurrentWeather weather(int cityId) throws JAXBException, IOException, SAXException;

}
