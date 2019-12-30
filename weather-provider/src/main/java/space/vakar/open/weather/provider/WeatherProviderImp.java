package space.vakar.open.weather.provider;

import com.google.gson.Gson;
import java.util.Optional;
import space.vakar.weather.domain.api.WeatherProvider;
import space.vakar.weather.domain.model.WeatherDto;

public class WeatherProviderImp implements WeatherProvider {

  private OpenWeatherClient apiClient = new OpenWeatherClientImp();
  private Gson gson = new Gson();

  @Override
  public Optional<WeatherDto> provideWeatherForCityWithId(int cityId) {
    String weatherJson = apiClient.getCityWeatherJsonByCityId(cityId);
    WeatherDto weather = gson.fromJson(weatherJson, WeatherDto.class);
    return Optional.ofNullable(weather);
  }

}
