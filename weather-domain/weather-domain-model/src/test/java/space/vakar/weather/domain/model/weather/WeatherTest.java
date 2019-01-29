package space.vakar.weather.domain.model.weather;

public class WeatherTest extends AbstractJavaBeanTest<Weather> {

  @Override
  protected Weather getBeanInstance() {
    return new Weather();
  }
}
