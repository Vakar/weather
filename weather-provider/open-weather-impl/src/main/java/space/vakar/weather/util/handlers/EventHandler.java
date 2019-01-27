package space.vakar.weather.util.handlers;

import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;

import org.apache.log4j.Logger;

public class EventHandler implements ValidationEventHandler {

  private static final Logger LOG = Logger.getLogger(EventHandler.class);

  @Override
  public boolean handleEvent(ValidationEvent event) {
    LOG.debug(event.getMessage());
    return false;
  }
}
