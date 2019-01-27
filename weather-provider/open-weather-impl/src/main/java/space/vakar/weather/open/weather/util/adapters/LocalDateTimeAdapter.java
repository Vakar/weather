package space.vakar.weather.open.weather.util.adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDateTime;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime> {

  @Override
  public String marshal(LocalDateTime dateTime) throws Exception {
    return dateTime.toString();
  }

  @Override
  public LocalDateTime unmarshal(String dateTime) throws Exception {
    return LocalDateTime.parse(dateTime);
  }
}
