package space.vakar.weather.service;

import space.vakar.weather.domain.model.Weather;
import space.vakar.weather.service.api.Agent;
import java.util.Objects;

public class ServiceImpl implements space.vakar.weather.service.api.Service {
	
	private Agent agent;

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
		if (object instanceof ServiceImpl) {
			ServiceImpl that = (ServiceImpl) object;
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
