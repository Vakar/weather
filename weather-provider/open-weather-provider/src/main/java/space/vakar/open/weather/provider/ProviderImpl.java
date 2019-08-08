package space.vakar.open.weather.provider;

import space.vakar.weather.domain.api.Provider;
import space.vakar.weather.domain.model.WeatherDTO;

public class ProviderImpl implements Provider {

  private ApiClient apiClient = ApiClientBuilder.getDejaultJsonApiConnector();

  @Override
  public WeatherDTO provideWeather(int cityId) {
    String json = apiClient.getCityWeatherJsonByCityId(cityId);
    return JsonDeserializer.convertJsonToWeatherDTO(json);
  }

}
