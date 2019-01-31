package space.vakar.weather.domain.model.weather.atmosphere;

public enum PrecipitationUnit {
  MILLIMETRE("mm"),
  CENTIMETRE("cm"),
  INCH("in");

  private final String shortName;

  PrecipitationUnit(String shortName) {
    this.shortName = shortName;
  }

  public String getShortName() {
    return this.shortName;
  }
}
