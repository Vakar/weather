package space.vakar.weather.domain;

public enum TemperatureUnit {
	
	KELVIN("kelvin"), 
	CELSIUS("celsius"), 
	FAHRENHEIT("fahrenheit"), 
	UNIT_UNKNOWN("unit_unknown");

	private final String openWeatherName;

	TemperatureUnit(String openWeatherName) {
		this.openWeatherName = openWeatherName;
	}

	public String openWeatherName() {
		return openWeatherName;
	}
}
