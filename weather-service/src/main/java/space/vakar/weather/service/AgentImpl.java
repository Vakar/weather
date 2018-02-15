package space.vakar.weather.service;

import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.Agent;
import space.vakar.weather.service.api.WeatherContainer;
import java.util.Objects;

public class AgentImpl implements Agent {

  private WeatherProvider provider;
  private WeatherContainer container;

  @Override
  public Weather weather(int cityId) {
    return isValide(cityId) ? send(cityId) : refreshAndSend(cityId);
  }

  private boolean isValide(int cityId) {
    return container.isExist(cityId) && container.isFresh(cityId);
  }

  private Weather send(int cityId) {
    return container.pull(cityId);
  }

  private Weather refreshAndSend(int cityId) {
    Weather weather = null;
    try {
      weather = provider.provideWeather(cityId);
    } catch (Exception e) {
      new WeatherServiceException("Can't receive weather from provider module", e);
    }
    container.push(weather);
    return weather;
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
