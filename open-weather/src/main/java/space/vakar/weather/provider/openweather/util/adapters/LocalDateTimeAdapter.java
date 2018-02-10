package space.vakar.weather.provider.openweather.util.adapters;

import java.time.LocalDateTime;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class LocalDateTimeAdapter extends XmlAdapter<String, LocalDateTime>{

	@Override
	public String marshal(LocalDateTime dateTime) throws Exception {
		return dateTime.toString();
	}

	@Override
	public LocalDateTime unmarshal(String dateTime) throws Exception {
		return LocalDateTime.parse(dateTime);
	}	
}
