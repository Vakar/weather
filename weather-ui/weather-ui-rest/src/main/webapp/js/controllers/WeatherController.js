import Converter from "../utils/Converter.js";
export default class WeatherController {
  constructor() {
    // Html Views
    this.cityNameView = document.getElementById("cityName");
    this.humidityView = document.getElementById("humidity");
    this.temperatureView = document.getElementById("temperature");
    this.windView = document.getElementById("wind");
    this.iconView = document.getElementById("icon");
    // Weather Icon Properties
    this.iconLink = "http://openweathermap.org/img/wn/";
    this.iconLinkEnd = "@2x.png";
    this.iconSize = 100; // in pixels
    // Unit Glyphs
    this.humidityUnit = "%"; // Percents
    this.celsiusUnitGlyph = "&#8451;"; // glyph view -> ℃
    this.fahrenheitUnitGlyph = "&#8457;"; // glyph view -> ℉
    this.windUnit = "m/s"; // Meters per second
  }

  showCity(cityName, countryCode) {
    this.cityNameView.innerHTML = `<span>City: </span> ${cityName}, ${countryCode}`;
  }

  showHumidity(humidity) {
    this.humidityView.innerHTML = `<span>Humidity: </span> ${humidity}${this.humidityUnit}`;
  }

  showTemperature(temperatureInKelvin) {
    let tempInCelsius = Math.round(
      Converter.kelvinToCelsius(temperatureInKelvin)
    );
    let tempInFahrenheit = Math.round(
      Converter.kelvinToFahrenheit(temperatureInKelvin)
    );
    this.temperatureView.innerHTML = `<span>Temperature: </span> ${tempInCelsius}${this.celsiusUnitGlyph} | ${tempInFahrenheit}${this.fahrenheitUnitGlyph}`;
  }

  showWind(windSpeed) {
    this.windView.innerHTML = `<span>Wind Speed: </span> ${windSpeed} ${this.windUnit}`;
  }

  showIcon(icon, altText) {
    this.cleanIcon();
    let img = document.createElement("IMG");
    img.setAttribute("src", this.iconLink + icon + this.iconLinkEnd);
    img.setAttribute("alt", altText);
    img.setAttribute("width", this.iconSize);
    img.setAttribute("height", this.iconSize);
    this.iconView.appendChild(img);
  }

  cleanWeather() {
    let empty = "";
    this.cityNameView.innerHTML = empty;
    this.humidityView.innerHTML = empty;
    this.temperatureView.innerHTML = empty;
    this.windView.innerHTML = empty;
    this.cleanIcon();
  }

  cleanIcon() {
    while (this.iconView.firstChild) {
      this.iconView.removeChild(this.iconView.firstChild);
    }
  }
}
