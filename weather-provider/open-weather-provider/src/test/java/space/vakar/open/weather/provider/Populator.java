package space.vakar.open.weather.provider;

import space.vakar.weather.domain.model.Clouds;
import space.vakar.weather.domain.model.Coord;
import space.vakar.weather.domain.model.Main;
import space.vakar.weather.domain.model.Sys;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.domain.model.WeatherDto;
import space.vakar.weather.domain.model.Wind;

import java.math.BigDecimal;
import java.util.Collections;

public class Populator {

  static WeatherDto populate(WeatherDto weatherDto) {
    Coord coord = new Coord(new BigDecimal("-0.13"), new BigDecimal("51.51"));
    Weather weather =
        Weather.builder().id(800).main("Clear").description("clear sky").icon("01d").build();
    Main main =
        Main.builder()
            .temp(new BigDecimal("297.15"))
            .pressure(new BigDecimal("1017"))
            .humidity(new BigDecimal("34"))
            .tempMin(new BigDecimal("293.71"))
            .tempMax(new BigDecimal("300.37"))
            .build();
    Wind wind = Wind.builder().speed(new BigDecimal("3.1")).deg(new BigDecimal("350")).build();
    Clouds clouds = new Clouds(0);
    Sys sys =
        Sys.builder()
            .type(1)
            .id(1414)
            .message(new BigDecimal("0.0107"))
            .country("GB")
            .sunrise(1563249691)
            .sunset(1563307869)
            .build();
    weatherDto.setCoord(coord);
    weatherDto.setWeather(Collections.singletonList(weather));
    weatherDto.setBase("stations");
    weatherDto.setMain(main);
    weatherDto.setVisibility(new BigDecimal("10000"));
    weatherDto.setWind(wind);
    weatherDto.setClouds(clouds);
    weatherDto.setDt(1563300768);
    weatherDto.setSys(sys);
    weatherDto.setTimezone(3600);
    weatherDto.setId(2643743);
    weatherDto.setName("London");
    weatherDto.setCod(200);
    return weatherDto;
  }
}
