package space.vakar.weather.domain.core;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import space.vakar.weather.domain.model.WeatherDto;

import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WeatherServiceImpl implements WeatherService {

  private WeatherAgent agent = new WeatherAgentImp();

  @Override
  public Optional<WeatherDto> weather(int cityId) {
    return agent.getWeatherByCityId(cityId);
  }

  @Override
  public int getWeatherExpireTime(WeatherDto weather) {
    long weatherTimestampMillis = weather.getDt() * 1000;
    long now = System.currentTimeMillis();
    long weatherAge = now - weatherTimestampMillis;
    return (int) (WeatherAgentImp.MAX_ACTUAL_TIME - weatherAge) / 1000;
  }
}
