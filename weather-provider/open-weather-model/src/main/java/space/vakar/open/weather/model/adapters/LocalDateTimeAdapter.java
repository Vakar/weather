package space.vakar.open.weather.model.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

  @Override
  public String marshal(LocalDateTime dateTime) {
    return dateTime.toString();
  }

  @Override
  public LocalDateTime unmarshal(String dateTime) {
    return LocalDateTime.parse(dateTime);
  }
}
