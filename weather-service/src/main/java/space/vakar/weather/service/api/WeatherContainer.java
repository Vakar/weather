package space.vakar.weather.service.api;

import java.io.Serializable;
import space.vakar.weather.domain.model.impl.Weather;

public interface WeatherContainer extends Serializable {

  /**
   * Contain {@link Weather} objects and provide access to them.
   *
   * @param weather on the city
   * @param cityId is a unique number of city that used to represent weather for given city
   */
  public void push(Weather weather, int cityId);

  public Weather pull(int cityId);
}
