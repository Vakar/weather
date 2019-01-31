package space.vakar.weather.ui.jsp.model;

import java.util.Objects;

public class WeatherWebModel {

  private String cityName;
  private String cityLon;
  private String cityLat;
  private String country;
  private String sunRise;
  private String sunSet;
  private String temperatureValue;
  private String temperatureUnit;
  private String humidityValue;
  private String humidityUnit;
  private String pressureValue;
  private String pressureUnit;
  private String windSpeed;
  private String windName;
  private String windDirection;
  private String cloudsValue;
  private String cloudsName;
  private String lastUpdate;

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public String getSunRise() {
    return sunRise;
  }

  public void setSunRise(String sunRise) {
    this.sunRise = sunRise;
  }

  public String getSunSet() {
    return sunSet;
  }

  public void setSunSet(String sunSet) {
    this.sunSet = sunSet;
  }

  public String getPressureValue() {
    return pressureValue;
  }

  public void setPressureValue(String pressureValue) {
    this.pressureValue = pressureValue;
  }

  public String getPressureUnit() {
    return pressureUnit;
  }

  public void setPressureUnit(String pressureUnit) {
    this.pressureUnit = pressureUnit;
  }

  public String getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(String windSpeed) {
    this.windSpeed = windSpeed;
  }

  public String getWindName() {
    return windName;
  }

  public void setWindName(String windName) {
    this.windName = windName;
  }

  public String getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(String windDirection) {
    this.windDirection = windDirection;
  }

  public String getCloudsValue() {
    return cloudsValue;
  }

  public void setCloudsValue(String cloudsValue) {
    this.cloudsValue = cloudsValue;
  }

  public String getCloudsName() {
    return cloudsName;
  }

  public void setCloudsName(String cloudsName) {
    this.cloudsName = cloudsName;
  }

  public String getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(String lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public String getCityName() {
    return cityName;
  }

  public void setCityName(String cityName) {
    this.cityName = cityName;
  }

  public String getCityLon() {
    return cityLon;
  }

  public void setCityLon(String cityLon) {
    this.cityLon = cityLon;
  }

  public String getCityLat() {
    return cityLat;
  }

  public void setCityLat(String cityLat) {
    this.cityLat = cityLat;
  }

  public String getTemperatureValue() {
    return temperatureValue;
  }

  public void setTemperatureValue(String temperatureValue) {
    this.temperatureValue = temperatureValue;
  }

  public String getTemperatureUnit() {
    return temperatureUnit;
  }

  public void setTemperatureUnit(String temperatureUnit) {
    this.temperatureUnit = temperatureUnit;
  }

  public String getHumidityValue() {
    return humidityValue;
  }

  public void setHumidityValue(String humidityValue) {
    this.humidityValue = humidityValue;
  }

  public String getHumidityUnit() {
    return humidityUnit;
  }

  public void setHumidityUnit(String humidityUnit) {
    this.humidityUnit = humidityUnit;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        cityName, cityLon, cityLat, temperatureValue, temperatureUnit, humidityValue, humidityUnit);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof WeatherWebModel) {
      WeatherWebModel that = (WeatherWebModel) object;
      return Objects.equals(this.cityName, that.cityName)
          && Objects.equals(this.cityLon, that.cityLon)
          && Objects.equals(this.cityLat, that.cityLat)
          && Objects.equals(this.temperatureValue, that.temperatureValue)
          && Objects.equals(this.temperatureUnit, that.temperatureUnit)
          && Objects.equals(this.humidityValue, that.humidityValue)
          && Objects.equals(this.humidityUnit, that.humidityUnit);
    }
    return false;
  }

  @Override
  public String toString() {
    return String.format(
        "WeatherWebModel [cityName=%s, cityLon=%s, cityLat=%s, temperatureValue=%s, temperatureUnit=%s, humidityValue=%s, humidityUnit=%s]",
        cityName, cityLon, cityLat, temperatureValue, temperatureUnit, humidityValue, humidityUnit);
  }
}
