package space.vakar.weather.service.api;

import java.io.Serializable;
import space.vakar.weather.domain.model.Weather;

public interface WeatherContainer extends Serializable{	
  
  /**
   * Set object to container
   * @param weather on the city
   * @param cityId is a unique number of city that used to represent weather for given city
   * @throws IllegalArgumentException when argument is null or below zero
   */
	public void push(Weather weather, int cityId) throws IllegalArgumentException;
	public Weather pull(int cityId);
	public boolean isExist(int cityId);
	public boolean isFresh(int cityId);
}