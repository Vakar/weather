package space.vakar.weather.web.model;

import java.util.Objects;

public class WeatherWebModel {
  
  private String cityName;
  private String cityLon;
  private String cityLat;
  private String temperatureValue;
  private String temperatureUnit;
  private String humidityValue;
  private String humidityUnit;
  
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
    return Objects.hash(cityName, cityLon, cityLat, temperatureValue, temperatureUnit,
        humidityValue, humidityUnit);
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
