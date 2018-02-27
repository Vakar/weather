package space.vakar.weather.service.impl;

import com.google.gson.Gson;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;
import org.apache.log4j.Logger;
import space.vakar.weather.domain.model.impl.Weather;
import space.vakar.weather.provider.openweather.api.Provider;
import space.vakar.weather.provider.openweather.impl.ProviderImpl;
import space.vakar.weather.service.api.Agent;
import space.vakar.weather.service.api.WeatherContainer;

public class AgentImpl implements Agent {

  private static final Logger LOG = Logger.getLogger(AgentImpl.class);

  private Provider provider = new ProviderImpl();
  private WeatherContainer container = new Container();

  private static final Duration TWO_HOURS = Duration.ofHours(2);

  public AgentImpl() {

  }

  public AgentImpl(Provider provider, WeatherContainer container) {
    setProvider(provider);
    setContainer(container);
  }

  @Override
  public Weather weather(int cityId) {
    Weather weather = container.pull(cityId);
    return isValide(weather) ? weather : askProviderAndCash(cityId);
  }

  private boolean isValide(Weather weather) {
    return weather != null && isFresh(weather);
  }

  // FIXME work not correct
  @Override
  public boolean isFresh(Weather weather) {
    Duration lastUpdateDelta =
        Duration.between(weather.getLastUpdate(), LocalDateTime.now(ZoneId.of("UTC")));
    return lastUpdateDelta.compareTo(TWO_HOURS) < 0 ? true : false;
  }

  private Weather askProviderAndCash(int cityId) {
    Weather weather = null;
    try {
      weather = provider.provideWeather(cityId);
      LOG.debug("Get weather from provider: " + new Gson().toJson(weather));
      container.push(weather, cityId);
    } catch (Exception e) {
      throw new WeatherServiceException("Can't get weather from provider", e);
    }
    return weather;
  }

  public Provider getProvider() {
    return provider;
  }

  public void setProvider(Provider provider) {
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
    if (object instanceof AgentImpl) {
      AgentImpl that = (AgentImpl) object;
      return Objects.equals(this.provider, that.provider)
          && Objects.equals(this.container, that.container);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "AgentImpl [provider=%s, container=%s]";
    return String.format(format, provider, container);
  }
}
