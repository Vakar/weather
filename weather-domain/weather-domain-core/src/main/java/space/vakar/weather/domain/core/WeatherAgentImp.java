package space.vakar.weather.domain.core;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Predicate;
import space.vakar.open.weather.provider.WeatherProviderImp;
import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.WeatherDto;

class WeatherAgentImp implements WeatherAgent {

  private WeatherContainer container = new WeatherContainerImp();
  private WeatherProvider provider = new WeatherProviderImp();

  static final int MAX_ACTUAL_TIME = 120 * 60 * 1000;

  public WeatherAgentImp() {}

  public WeatherAgentImp(WeatherProvider provider, WeatherContainer container) {
    this.provider = provider;
    this.container = container;
  }

  @Override
  public Optional<WeatherDto> getWeatherByCityId(int cityId) {
    Optional<WeatherDto> optionalWeatherDto = getWeatherFromContainer(cityId);
    return optionalWeatherDto.isPresent() ? optionalWeatherDto : getWeatherFromProvider(cityId);
  }

  Optional<WeatherDto> getWeatherFromContainer(int cityId) {
    Optional<WeatherDto> optionalWeatherDto = container.pull(cityId);
    return optionalWeatherDto.filter(isFresh);
  }

  Predicate<WeatherDto> isFresh = weatherDto -> {
    long weatherLastUpdate = weatherDto.getDt();
    long now = System.currentTimeMillis();
    long timeDelta = now - weatherLastUpdate;
    return timeDelta < MAX_ACTUAL_TIME;
  };

  Optional<WeatherDto> getWeatherFromProvider(int cityId) {
    return provider.provideWeather(cityId).map(weather -> {
      container.push(weather);
      return weather;
    });
  }

  public WeatherProvider getProvider() {
    return provider;
  }

  public void setProvider(WeatherProvider provider) {
    this.provider = provider;
  }

  public WeatherContainer getContainer() {
    return container;
  }

  public void setContainer(WeatherContainer container) {
    this.container = container;
  }

  @Override
  public int hashCode() {
    return Objects.hash(provider, container);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof WeatherAgentImp) {
      WeatherAgentImp that = (WeatherAgentImp) object;
      return Objects.equals(this.provider, that.provider)
          && Objects.equals(this.container, that.container);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "WeatherAgentImp [provider=%s, container=%s]";
    return String.format(format, provider, container);
  }

}
