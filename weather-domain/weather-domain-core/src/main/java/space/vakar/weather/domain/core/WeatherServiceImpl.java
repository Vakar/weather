package space.vakar.weather.domain.core;

import java.util.Optional;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import space.vakar.weather.domain.model.WeatherDto;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WeatherServiceImpl implements WeatherService {

  private WeatherAgent agent = new WeatherAgentImp();

  @Override
  public Optional<WeatherDto> findWeatherForCityWithId(int cityId) {
    return agent.findWeatherForCityWithId(cityId);
  }

  @Override
  public int calculateWeatherExpireTime(WeatherDto weather) {
    long weatherTimestampMillis = weather.getDt() * 1000;
    long now = System.currentTimeMillis();
    long weatherAge = now - weatherTimestampMillis;
    return (int) (WeatherAgentImp.MAX_ACTUAL_TIME - weatherAge) / 1000;
  }
}
