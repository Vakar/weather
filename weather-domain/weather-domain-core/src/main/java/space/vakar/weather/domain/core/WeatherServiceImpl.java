package space.vakar.weather.domain.core;

import java.util.Objects;
import java.util.Optional;
import space.vakar.weather.domain.model.WeatherDto;

public class WeatherServiceImpl implements WeatherService {

  private WeatherAgent agent = new WeatherAgentImp();

  /**
   * Default constructor.
   */
  public WeatherServiceImpl() {}

  /**
   * Create {WeatherServiceImpl} with given {WeatherAgent}.
   * @param agent weather agent
   */
  public WeatherServiceImpl(WeatherAgent agent) {
    setAgent(agent);
  }

  @Override
  public Optional<WeatherDto> weather(int cityId) {
    return agent.getWeatherByCityId(cityId);
  }

  /**
   * Get weather agent.
   * @return weather agent
   */
  public WeatherAgent getAgent() {
    return agent;
  }

  /**
   * Set weather agent.
   * @param agent weather agent
   */
  public void setAgent(WeatherAgent agent) {
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
