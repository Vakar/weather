package space.vakar.weather.provider.openweather.util.handlers;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

public class EventHandler implements ValidationEventHandler {

  @Override
  public boolean handleEvent(ValidationEvent event) {

    return false;
  }

}
