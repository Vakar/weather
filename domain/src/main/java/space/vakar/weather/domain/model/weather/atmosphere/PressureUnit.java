package space.vakar.weather.domain.model.weather.atmosphere;

public enum PressureUnit {
  MILLIBAR("mbar"), MILLIMETER_OF_MERCURY("mmHg");

  private final String shortName;

  private PressureUnit(String shortName) {
    this.shortName = shortName;
  }

  public String getShortName() {
    return this.shortName;
  }
}
