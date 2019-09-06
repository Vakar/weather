package space.vakar.open.weather.provider;

import java.math.BigDecimal;
import java.util.Collections;
import space.vakar.weather.domain.model.Clouds;
import space.vakar.weather.domain.model.Coord;
import space.vakar.weather.domain.model.Main;
import space.vakar.weather.domain.model.Sys;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.domain.model.WeatherDto;
import space.vakar.weather.domain.model.Wind;


public class WeatherDtoPopulator {

  static WeatherDto populate(WeatherDto weatherDto) {
    Coord coord = new Coord(new BigDecimal("-0.13"), new BigDecimal("51.51"));
    Weather weather =
        new Weather().withId(800).withMain("Clear").withDescription("clear sky").withIcon("01d");
    Main main = new Main().withTemp(new BigDecimal("297.15")).withPressure(new BigDecimal("1017"))
        .withHumidity(new BigDecimal("34")).withTempMin(new BigDecimal("293.71"))
        .withTempMax(new BigDecimal("300.37"));
    Wind wind = new Wind().withSpeed(new BigDecimal("3.1")).withDeg(new BigDecimal("350"));
    Clouds clouds = new Clouds(0);
    Sys sys = new Sys().withType(1).withId(1414).withMessage(new BigDecimal("0.0107"))
        .withCountry("GB").withSunrise(1563249691).withSunset(1563307869);

    return weatherDto.withCoord(coord).withWeather(Collections.singletonList(weather))
        .withBase("stations").withMain(main).withVisibility(new BigDecimal("10000")).withWind(wind)
        .withClouds(clouds).withDt(1563300768).withSys(sys).withTimezone(3600).withId(2643743)
        .withName("London").withCod(200);
  }

}
