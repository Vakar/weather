package space.vakar.weather.provider.openweather.impl;

import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import space.vakar.weather.provider.openweather.api.Parser;
import space.vakar.weather.provider.openweather.api.Retriever;
import space.vakar.weather.provider.openweather.exceptions.WeatherParserException;
import space.vakar.weather.provider.openweather.model.CurrentWeather;
import space.vakar.weather.provider.openweather.util.handlers.EventHandler;

class ParserImpl implements Parser<CurrentWeather> {

  private Retriever retriever = RetrieverImplBuilder.buildRetriever();

  public ParserImpl() {
  }

  public ParserImpl(Retriever retriever) {
    this.retriever = retriever;
  }

  @Override
  public CurrentWeather weather(int cityId) throws WeatherParserException {
    CurrentWeather weather;
    try {
      Unmarshaller unmarshaller = unmarshaller(CurrentWeather.class);
      unmarshaller.setSchema(schema("current.xsd"));
      unmarshaller.setEventHandler(new EventHandler());
      weather = (CurrentWeather) unmarshaller.unmarshal(retriever.weatherXml(cityId));
    } catch (Exception e) {
      throw new WeatherParserException("Can't not unmarshal weather XML.", e);
    }
    return weather;
  }

  private Unmarshaller unmarshaller(Class<?> clazz) throws JAXBException {
    return JAXBContext.newInstance(clazz).createUnmarshaller();
  }

  private Schema schema(String fileName) throws SAXException {
    SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    return sf.newSchema(file(fileName));
  }

  private File file(String fileName) {
    ClassLoader classLoader = getClass().getClassLoader();
    return new File(classLoader.getResource(fileName).getFile());
  }

  public Retriever getRetriever() {
    return retriever;
  }

  public void setRetriever(Retriever retriever) {
    this.retriever = retriever;
  }
}
