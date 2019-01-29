package space.vakar.weather.domain.impl;

import java.util.Objects;
import space.vakar.weather.domain.model.weather.Weather;
import space.vakar.weather.domain.api.Agent;
import space.vakar.weather.domain.api.WeatherService;

public class WeatherServiceImpl implements WeatherService {

  private Agent agent = new AgentImpl();

  public WeatherServiceImpl() {}

  public WeatherServiceImpl(Agent agent) {
    setAgent(agent);
  }

  @Override
  public Weather weather(int cityId) {
    return agent.weather(cityId);
  }

  public Agent getAgent() {
    return agent;
  }

  public void setAgent(Agent agent) {
    this.agent = agent;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(agent);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof WeatherServiceImpl) {
      WeatherServiceImpl that = (WeatherServiceImpl) object;
      return Objects.equals(this.agent, that.agent);
    }
    return false;
  }

  @Override
  public String toString() {
    String format = "ServiceImpl [agent=%s]";
    return String.format(format, agent);
  }
}
