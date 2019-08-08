package space.vakar.weather.domain.core;

import java.util.Objects;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import space.vakar.open.weather.provider.ProviderImpl;
import space.vakar.weather.domain.api.Provider;
import space.vakar.weather.domain.model.WeatherDTO;

class AgentImpl implements Agent {

	private static final Logger LOG = Logger.getLogger(AgentImpl.class);

	private Provider provider = new ProviderImpl();
	private WeatherContainer container = new WeatherContainerImpl();

	private static final int MINUTES_120 = 1000 * 60 * 120;

	AgentImpl() {
	}

	AgentImpl(Provider provider, WeatherContainer container) {
		setProvider(provider);
		setContainer(container);
	}

	@Override
	public WeatherDTO weather(int cityId) {
		WeatherDTO weather = container.pull(cityId);
		return isValid(weather) ? weather : askProviderAndCash(cityId);
	}

	private boolean isValid(WeatherDTO weather) {
		return weather != null && isFresh(weather);
	}

	@Override
	public boolean isFresh(WeatherDTO weather) {
		long weatherLastUpdate = weather.getDt();
		long now = System.currentTimeMillis();
		long delta = now - weatherLastUpdate;
		return delta < MINUTES_120;
	}

	private WeatherDTO askProviderAndCash(int cityId) {
		WeatherDTO weather;
		try {
			weather = provider.provideWeather(cityId);
			LOG.debug("Get weather from provider: " + new Gson().toJson(weather));
			if (weather != null)
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
			return Objects.equals(this.provider, that.provider) && Objects.equals(this.container, that.container);
		}
		return false;
	}

	@Override
	public String toString() {
		String format = "AgentImpl [provider=%s, container=%s]";
		return String.format(format, provider, container);
	}
}
