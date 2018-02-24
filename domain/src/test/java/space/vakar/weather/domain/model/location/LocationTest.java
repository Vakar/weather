package space.vakar.weather.domain.model.location;

import space.vakar.weather.domain.model.AbstractJavaBeanTest;
import space.vakar.weather.domain.model.impl.location.Location;

public class LocationTest extends AbstractJavaBeanTest<Location> {

	@Override
	protected Location getBeanInstance() {
		return new Location();
	}
}
