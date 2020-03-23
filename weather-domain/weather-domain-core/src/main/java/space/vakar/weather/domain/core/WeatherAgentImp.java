package space.vakar.weather.domain.core;

import java.util.Optional;
import java.util.function.Predicate;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import space.vakar.open.weather.provider.WeatherProviderImp;
import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.WeatherDto;

@Getter
@Setter
@EqualsAndHashCode
@ToString
class WeatherAgentImp implements WeatherAgent {

  private WeatherContainer container = new WeatherContainerImp();
  private WeatherProvider provider = new WeatherProviderImp();

  static final int MAX_ACTUAL_TIME = 120 * 60 * 1000;

  @Override
  public Optional<WeatherDto> findWeatherForCityWithId(int cityId) {
    Optional<WeatherDto> optionalWeatherDto = getWeatherFromContainer(cityId);
    return optionalWeatherDto.isPresent() ? optionalWeatherDto : getWeatherFromProvider(cityId);
  }

  Optional<WeatherDto> getWeatherFromContainer(int cityId) {
    Optional<WeatherDto> optionalWeatherDto = container.pull(cityId);
    return optionalWeatherDto.filter(isFresh);
  }

  Predicate<WeatherDto> isFresh =
      weatherDto -> {
        long weatherLastUpdate = weatherDto.getDt();
        long now = System.currentTimeMillis();
        long timeDelta = now - weatherLastUpdate;
        return timeDelta < MAX_ACTUAL_TIME;
      };

  Optional<WeatherDto> getWeatherFromProvider(int cityId) {
    return provider
        .provideWeatherForCityWithId(cityId)
        .map(
            weather -> {
              container.push(weather);
              return weather;
            });
  }
}
