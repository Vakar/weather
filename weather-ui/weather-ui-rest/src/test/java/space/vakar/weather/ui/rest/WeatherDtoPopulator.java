package space.vakar.weather.ui.rest;

import java.math.BigDecimal;
import java.util.Collections;

import space.vakar.weather.domain.model.Clouds;
import space.vakar.weather.domain.model.Coord;
import space.vakar.weather.domain.model.Main;
import space.vakar.weather.domain.model.Sys;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.domain.model.WeatherDTO;
import space.vakar.weather.domain.model.Wind;

// TODO: this a code duplication
public class WeatherDtoPopulator {

	public static WeatherDTO populate(WeatherDTO weatherDTO) {
		Coord coord = new Coord().withLon(new BigDecimal("-0.13")).withLat(new BigDecimal("51.51"));
		Weather weather = new Weather().withId(800).withMain("Clear").withDescription("clear sky").withIcon("01d");
		Main main = new Main().withTemp(new BigDecimal("297.15")).withPressure(1017).withHumidity(34)
				.withTempMin(new BigDecimal("293.71")).withTempMax(new BigDecimal("300.37"));
		Wind wind = new Wind().withSpeed(new BigDecimal("3.1")).withGust(new BigDecimal("8.7"));
		Clouds clouds = new Clouds().withAll(0);
		Sys sys = new Sys().withType(1).withId(1414).withMessage(new BigDecimal("0.0107")).withCountry("GB")
				.withSunrise(1563249691).withSunset(1563307869);

		weatherDTO.withCoord(coord).withWeather(Collections.singletonList(weather)).withBase("stations").withMain(main)
				.withVisibility(10000).withWind(wind).withClouds(clouds).withDt(1563300768).withSys(sys)
				.withTimezone(3600).withId(2643743).withName("London").withCod(200);
		return weatherDTO;
	}

}
