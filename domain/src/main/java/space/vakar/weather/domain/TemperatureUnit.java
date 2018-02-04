package space.vakar.weather.domain;

public enum TemperatureUnit {
	KELVIN("Kelvin"), CELSIUS("Celsius"), FAHRENHEIT("Fahrenheit"), UNIT_UNKNOWN("Unit unknown");

	private final String unitName;

	TemperatureUnit(String name) {
		this.unitName = name;
	}

	public String unitName() {
		return unitName;
	}
}
