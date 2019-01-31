package space.vakar.open.weather.impl;

import org.xml.sax.SAXException;
import space.vakar.open.weather.api.Parser;
import space.vakar.open.weather.api.Retriever;
import space.vakar.open.weather.model.CurrentWeather;
import space.vakar.open.weather.impl.util.handlers.EventHandler;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;

class ParserImpl implements Parser<CurrentWeather> {

  private Retriever retriever = RetrieverImplBuilder.buildRetriever();

  public ParserImpl() {}

  public ParserImpl(Retriever retriever) {
    this.retriever = retriever;
  }

  @Override
  public CurrentWeather weather(int cityId) {
    CurrentWeather weather;
    try {
      Unmarshaller unmarshaller = unmarshaller(CurrentWeather.class);
      unmarshaller.setSchema(schema("current.xsd"));
      unmarshaller.setEventHandler(new EventHandler());
      weather = (CurrentWeather) unmarshaller.unmarshal(retriever.weatherXml(cityId));
    } catch (Exception parsingException) {
      throw new OpenWeatherException("Can't not unmarshal weather XML.", parsingException);
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
