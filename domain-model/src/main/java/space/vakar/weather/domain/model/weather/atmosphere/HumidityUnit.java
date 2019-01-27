package space.vakar.weather.domain.model.weather.atmosphere;

public enum HumidityUnit {
  ABSOLUTE_HUMIDITY("m/V"),
  RELATIVE_HUMIDITY("%");
  private final String shortName;

  private HumidityUnit(String shortName) {
    this.shortName = shortName;
  }

  public String getShortName() {
    return this.shortName;
  }
}
