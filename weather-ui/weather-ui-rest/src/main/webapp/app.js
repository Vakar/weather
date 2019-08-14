// CONFIGURATION
const restWs = "rest/";
const cityRestWs = restWs + "city/";
const weatherRestWs = restWs + "weather/";

const iconLink = "http://openweathermap.org/img/wn/";
const iconLinkEnd = "@2x.png";
const iconSize = 100;

// VIEWS: DOM elements
var inputView = document.getElementById("searchInput");

var messageView = document.getElementById("message");

var cityNameView = document.getElementById("cityName");
var humidityView = document.getElementById("humidity");
var temperatureView = document.getElementById("temperature");
var windView = document.getElementById("wind");
var iconView = document.getElementById("icon");

var listOfCitiesView = document.getElementById("autocomplete-list");

const celsiusUnitGlyph = "&#8451;";
const fahrenheitUnitGlyph = "&#8457;";
const windUnit = "m/s";
const humidityUnit = "%";

// MODELS
var cityList = new Array(1); // TODO: THINK ABOUT INIT PARAMETER
var selectedCityId = 0; // TODO: THINK ABOUT INIT PARAMETER

// CONTROLLERS

// Controller: Search Button
document
  .getElementById("citySearch")
  .addEventListener("submit", searchButtonListener);

function searchButtonListener(e) {
  e.preventDefault();
  var inputString = inputView.value.trim();
  inputView.value = inputString;
  if (isEmpty(inputString)) {
    showMessage("City name should not be blank!");
  } else {
    eraseMessage();
    findCities(inputString);
  }
}

function isEmpty(str) {
  return !str || 0 === str.length;
}

function findCities(inputString) {
  var xhr = new XMLHttpRequest();
  xhr.open("GET", cityRestWs + inputString, true);
  xhr.onload = function() {
    if (this.status == 200) {
      cityList = JSON.parse(xhr.responseText);
      showAutocompleteList();
      autocomplete();
    }
  };
  xhr.send();
}

// -> Controller: Weather View
function getWeather(cityId) {
  console.log(cityId);
  var xhr = new XMLHttpRequest();
  xhr.open("GET", weatherRestWs + cityId, true);
  xhr.onload = function() {
    if (this.status == 200) var weather = JSON.parse(xhr.responseText);
    showCity(weather.name, weather.sys.country);
    showHumidity(weather.main.humidity);
    showTemperature(weather.main.temp);
    showWind(weather.wind.speed);
    showIcon(weather.weather[0].icon, weather.weather[0].description);
  };
  xhr.send();
}

function showCity(cityName, countryCode) {
  let cityDataLine = "<span>City: </span>";
  cityDataLine += cityName;
  cityDataLine += ", ";
  cityDataLine += countryCode;
  cityNameView.innerHTML = cityDataLine;
}

function showHumidity(humidity) {
  let humidityDataLine = "<span>Humidity: </span>";
  humidityDataLine += humidity;
  humidityDataLine += humidityUnit;
  humidityView.innerHTML = humidityDataLine;
}

function showTemperature(temperatureKelvin) {
  let tempDataLine = "<span>Temperature: </span>";
  tempDataLine += Math.round(convertKelvinToCelsius(temperatureKelvin));
  tempDataLine += celsiusUnitGlyph;
  tempDataLine += " | ";
  tempDataLine += Math.round(convertKelvinToFahrenheit(temperatureKelvin));
  tempDataLine += fahrenheitUnitGlyph;
  temperatureView.innerHTML = tempDataLine;
}

function convertKelvinToFahrenheit(kelvin) {
  let celsius = convertKelvinToCelsius(kelvin);
  return celsius * (9 / 5) + 32;
}

function convertKelvinToCelsius(kelvin) {
  return kelvin - 273.15;
}

function showWind(windSpeed) {
  let windDataLine = "<span>Wind Speed: </span>";
  windDataLine += windSpeed;
  windDataLine += " ";
  windDataLine += windUnit;
  windView.innerHTML = windDataLine;
}

function showIcon(icon, altText) {
  cleanIcon();
  var img = document.createElement("IMG");
  img.setAttribute("src", iconLink + icon + iconLinkEnd);
  img.setAttribute("alt", altText);
  img.setAttribute("width", iconSize);
  img.setAttribute("height", iconSize);
  iconView.appendChild(img);
}

function cleanIcon() {
  while (iconView.firstChild) {
    iconView.removeChild(iconView.firstChild);
  }
}

// -> Controller: Message View
function showMessage(message) {
  messageView.innerHTML = message;
}

function eraseMessage() {
  messageView.innerHTML = "";
}

// -> Controller: Autocomplete
function autocomplete() {
  inputView.addEventListener("input", showAutocompleteList);
  inputView.addEventListener("keydown", function(e) {
    if (e.keyCode == 13) e.preventDefault();
  });
  document.addEventListener("click", clearAutocompleteList);
}

function showAutocompleteList() {
  clearAutocompleteList();
  var inputValue = inputView.value;
  if (!inputValue) return false;
  for (var i in cityList) {
    var cityId = cityList[i].id;
    var cityName = cityList[i].name;
    var cityCountry = cityList[i].country;
    if (startsWith(cityName, inputValue)) {
      var item = document.createElement("DIV");
      item.setAttribute("class", "listItem");
      item.innerHTML = cityName + ", " + cityCountry;
      item.innerHTML += "<input type='hidden' value='" + cityId + "'>";
      item.innerHTML += "<input type='hidden' value='" + cityName + "'>";
      item.addEventListener("click", weatherOnClick);
      listOfCitiesView.appendChild(item);
    }
  }
}

function weatherOnClick() {
  var cityId = this.getElementsByTagName("input")[0].value;
  inputView.value = this.getElementsByTagName("input")[1].value;
  clearAutocompleteList();
  getWeather(cityId);
};

function startsWith(string, startsFrom) {
  var string = string.toUpperCase();
  var startsFrom = string.toUpperCase();
  return string.startsWith(startsFrom);
}

function clearAutocompleteList() {
  var elements = document.getElementsByClassName("listItem");
  while (elements.length > 0) {
    elements[0].removeEventListener("click", weatherOnClick, true);
    elements[0].parentNode.removeChild(elements[0]);
  }
}
