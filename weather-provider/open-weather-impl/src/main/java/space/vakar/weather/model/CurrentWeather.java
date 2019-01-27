package space.vakar.weather.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Objects;

@XmlRootElement(name = "current")
public class CurrentWeather {

  private City city;
  private Temperature temperature;
  private Humidity humidity;
  private Pressure pressure;
  private Wind wind;
  private Clouds clouds;
  private Visibility visibility;
  private Precipitation precipitation;
  private Weather weather;
  private LastUpdate lastupdate;

  public City getCity() {
    return city;
  }

  @XmlElement
  public void setCity(City city) {
    this.city = city;
  }

  public Temperature getTemperature() {
    return temperature;
  }

  @XmlElement
  public void setTemperature(Temperature temperature) {
    this.temperature = temperature;
  }

  public Humidity getHumidity() {
    return humidity;
  }

  @XmlElement
  public void setHumidity(Humidity humidity) {
    this.humidity = humidity;
  }

  public Pressure getPressure() {
    return pressure;
  }

  @XmlElement
  public void setPressure(Pressure pressure) {
    this.pressure = pressure;
  }

  public Wind getWind() {
    return wind;
  }

  @XmlElement
  public void setWind(Wind wind) {
    this.wind = wind;
  }

  public Clouds getClouds() {
    return clouds;
  }

  @XmlElement
  public void setClouds(Clouds clouds) {
    this.clouds = clouds;
  }

  public Visibility getVisibility() {
    return visibility;
  }

  @XmlElement
  public void setVisibility(Visibility visibility) {
    this.visibility = visibility;
  }

  public Precipitation getPrecipitation() {
    return precipitation;
  }

  @XmlElement
  public void setPrecipitation(Precipitation precipitation) {
    this.precipitation = precipitation;
  }

  public Weather getWeather() {
    return weather;
  }

  @XmlElement
  public void setWeather(Weather weather) {
    this.weather = weather;
  }

  public LastUpdate getLastupdate() {
    return lastupdate;
  }

  @XmlElement
  public void setLastupdate(LastUpdate lastupdate) {
    this.lastupdate = lastupdate;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        city,
        temperature,
        humidity,
        pressure,
        wind,
        clouds,
        visibility,
        precipitation,
        weather,
        lastupdate);
  }

  @Override
  public boolean equals(Object object) {
    if (object instanceof CurrentWeather) {
      CurrentWeather that = (CurrentWeather) object;
      return Objects.equals(this.city, that.city)
          && Objects.equals(this.temperature, that.temperature)
          && Objects.equals(this.humidity, that.humidity)
          && Objects.equals(this.pressure, that.pressure)
          && Objects.equals(this.wind, that.wind)
          && Objects.equals(this.clouds, that.clouds)
          && Objects.equals(this.visibility, that.visibility)
          && Objects.equals(this.precipitation, that.precipitation)
          && Objects.equals(this.weather, that.weather)
          && Objects.equals(this.lastupdate, that.lastupdate);
    }
    return false;
  }

  @Override
  public String toString() {
    String format =
        "Current [city=%s, temperature=%s, humidity=%s, "
            + "pressure=%s, wind=%s, clouds=%s, "
            + "visibility=%s, precipitation=%s, weather=%s, "
            + "lastupdate=%s]";
    return String.format(
        format,
        city,
        temperature,
        humidity,
        pressure,
        wind,
        clouds,
        visibility,
        precipitation,
        weather,
        lastupdate);
  }
}
