package space.vakar.weather.provider.openweather.util.handlers;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import space.vakar.weather.provider.openweather.OpenWeatherException;

public class EventHandler implements ValidationEventHandler {
  @Override
  public boolean handleEvent(ValidationEvent event) {
    throw new OpenWeatherException("XML validation error");
  }
}
