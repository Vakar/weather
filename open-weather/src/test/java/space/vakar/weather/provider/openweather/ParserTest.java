package space.vakar.weather.provider.openweather;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.xml.sax.SAXException;

import space.vakar.weather.provider.openweather.api.WeatherRetriever;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.testutils.CurrentWeatherPopulator;

@RunWith(MockitoJUnitRunner.class)
public class ParserTest {

	@Mock
	WeatherRetriever retriverMock;

	@InjectMocks
	Parser parser;

	CurrentWeather expectedWeather;
	InputStream inputStream;

	@Before
	public void setUp() throws IOException {
		expectedWeather = new CurrentWeather();
		CurrentWeatherPopulator.populateData(expectedWeather);
		ClassLoader loader = getClass().getClassLoader();
		inputStream = loader.getResource("weather.xml").openStream();
	}

	@Test
	public void shouldReturnCorrectObject() throws JAXBException, IOException {
		when(retriverMock.weatherXML(1)).thenReturn(inputStream);
		assertEquals(expectedWeather, parser.weather(1));
	}

	@Test
	public void validation() throws JAXBException, SAXException {
		JAXBContext context = JAXBContext.newInstance(CurrentWeather.class);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = sf.newSchema(new File("src/main/resources/current.xsd"));
		Unmarshaller unmarshaller = context.createUnmarshaller();
		unmarshaller.setSchema(schema);
		unmarshaller.setEventHandler(new EmployeeValidationEventHandler());
		CurrentWeather r = (CurrentWeather) unmarshaller.unmarshal(inputStream);
	}

	class EmployeeValidationEventHandler implements ValidationEventHandler {
		@Override
		public boolean handleEvent(ValidationEvent event) {
			System.out.println("\nEVENT");
			System.out.println("SEVERITY:  " + event.getSeverity());
			System.out.println("MESSAGE:  " + event.getMessage());
			return true;
		}
	}
}
