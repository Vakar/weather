package space.vakar.weather.domain.core;

import java.util.Objects;
import space.vakar.weather.domain.model.WeatherDto;

public class WeatherServiceImpl implements WeatherService {

  private Agent agent = new AgentImpl();

  /**
   * Default constructor.
   */
  public WeatherServiceImpl() {}

  /**
   * Create {WeatherServiceImpl} with given {Agent}.
   * @param agent weather agent
   */
  public WeatherServiceImpl(Agent agent) {
    setAgent(agent);
  }

  @Override
  public WeatherDto weather(int cityId) {
    return agent.weather(cityId);
  }

  /**
   * Get weather agent.
   * @return weather agent
   */
  public Agent getAgent() {
    return agent;
  }

  /**
   * Set weather agent.
   * @param agent weather agent
   */
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
