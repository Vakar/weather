package space.vakar.weather.domain.model;

public class WeatherTest extends AbstractJavaBeanTest<Weather> {

	@Override
	protected Weather getBeanInstance() {
		return new Weather();
	}

}
