package space.vakar.weather.impl;

import java.util.Objects;

public class Coord {

  private String lon;
  private String lat;

  public Coord(String lon, String lat) {
    this.lon = lon;
    this.lat = lat;
  }

  public String getLon() {
    return lon;
  }

  public void setLon(String lon) {
    this.lon = lon;
  }

  public String getLat() {
    return lat;
  }

  public void setLat(String lat) {
    this.lat = lat;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Coord)) return false;
    Coord coord = (Coord) o;
    return Objects.equals(lon, coord.lon) &&
            Objects.equals(lat, coord.lat);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lon, lat);
  }

  @Override
  public String toString() {
    return "Coord{" +
            "lon='" + lon + '\'' +
            ", lat='" + lat + '\'' +
            '}';
  }
}
