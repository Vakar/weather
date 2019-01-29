package space.vakar.weather.domain.model.weather.atmosphere;

public enum VisibilityUnit {
  METER("m"),
  KILOMETER("km");

  /** International System of Units symbol */
  private final String shortName;

  private VisibilityUnit(String shortName) {
    this.shortName = shortName;
  }

  public String getSymbol() {
    return this.shortName;
  }
}
