package space.vakar.weather.openweather;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import space.vakar.weather.domain.Weather;
import space.vakar.weather.domain.api.AbstractWeatherParser;

public class OpenWeatherParser extends AbstractWeatherParser{

	@Override
	public Weather parse(InputStream inputStream) throws DocumentException {
		SAXReader xmlReader = new SAXReader();
		Document doc = xmlReader.read(inputStream);
		String cityId = doc.valueOf( "//current/city/@id" );
		String cityName = doc.valueOf( "//current/city/@name" ); 
		String coordinatesLongtitute = doc.valueOf( "//current/city/coord@lon" );
		String coordinatesLatitute = doc.valueOf( "//current/city/coord@lat" );
		String country = doc.valueOf( "//current/city/country" );
		String sunRise = doc.valueOf( "//current/city/sun/@rise" );
		String sunSet = doc.valueOf( "//current/city/sun/@set" );
		String temperatureValue = doc.valueOf( "//current/temperature/@value" );
		String temperatureUnit = doc.valueOf( "//current/temperature/@unit" );
		String humidityValue = doc.valueOf( "//current/humidity/@value" );
		String humidityUnit = doc.valueOf( "//current/humidity/@unit" );
		String pressureValue = doc.valueOf( "//current/pressure/@value" );
		String pressureUnit = doc.valueOf( "//current/pressure/@unit" );
		String speedValue = doc.valueOf( "//current/wind/speed/@value" );
		String speedName = doc.valueOf( "//current/wind/speed/@name" );
		String gustsValue = doc.valueOf( "//current/wind/gusts/@value" );
		String directionValue = doc.valueOf( "//current/wind/direction/@value" );
		String directionCode = doc.valueOf( "//current/wind/direction/@code" );
		String directionName = doc.valueOf( "//current/wind/direction/@name" );
		String cloudsValue = doc.valueOf( "//current/clouds/@value" );
		String cloudsName = doc.valueOf( "//current/clouds/@name" );
		String visibilityValue = doc.valueOf( "//current/visibility/@value" );
		String precipitationValue = doc.valueOf( "//current/precipitation/@value" );
		String precipitationMode = doc.valueOf( "//current/precipitation/@mode" );
		String weatherValue = doc.valueOf( "//current/weather/@value" );
		String lastUpdateValue = doc.valueOf( "//current/lastupdate/@value" );
		return null;
	}
}
