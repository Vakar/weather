package space.vakar.weather.domain.model.weather.temperature;

/** Set of temperature units. */
public enum TemperatureUnit {
  KELVIN("K"),
  CELSIUS("°C"),
  FAHRENHEIT("°F"),
  UNIT_UNKNOWN("unknown");
  private final String shortName;

  private TemperatureUnit(String shortName) {
    this.shortName = shortName;
  }

  public String getShortName() {
    return this.shortName;
  }
}
