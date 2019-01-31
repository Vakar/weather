package space.vakar.weather.domain.model.weather.wind;

public enum SpeedUnit {
  METRES_PER_SECOND("m/s"),
  KILOMETRES_PER_HOUR("km/h"),
  MILES_PER_HOUR("mph");
  private final String shortName;

  SpeedUnit(String shortName) {
    this.shortName = shortName;
  }

  public String getShortName() {
    return this.shortName;
  }
}
