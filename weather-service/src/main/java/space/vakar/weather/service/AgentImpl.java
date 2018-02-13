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
	public Weather weather(String cityName) {
		return isValide(cityName) ? send(cityName) : refresh(cityName);
	}
	
	private boolean isValide(String cityName) {
		return container.isExist(cityName) && container.isFresh(cityName);
	}
	
	private Weather send(String cityName) {
		return container.pull(cityName);
	}
	
	private Weather refresh(int cityName) {
		Weather weather = provider.provideWeather(cityName);
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
