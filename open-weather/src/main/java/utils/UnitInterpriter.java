package utils;

import space.vakar.weather.domain.TemperatureUnit;

public class UnitInterpriter {
	
	public static TemperatureUnit interpriterTemperatureUnit(String unit) {
		if (unit.equals("celsius")) {
			return TemperatureUnit.CELSIUS;
		} else if(unit.equals("fahrenheit")){
			return TemperatureUnit.FAHRENHEIT;
		} else if(unit.equals("kelvin")) {
			return TemperatureUnit.KELVIN;
		} else {
			return TemperatureUnit.UNIT_UNKNOWN;
		}
	}

}
