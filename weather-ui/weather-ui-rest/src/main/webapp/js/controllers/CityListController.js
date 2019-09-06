import WeatherClient from "../clients/WeatherClient.js";
import WeatherController from "../controllers/WeatherController.js";
export default class CityListController {
  showAutocompleteList(cityList) {
    let elements = document.getElementsByClassName("listItem");
    while (elements.length > 0) {
      elements[0].parentNode.removeChild(elements[0]);
    }
    let inputValue = document.getElementById("searchInput");
    if (!inputValue) return false;
    for (let i in cityList) {
      let cityId = cityList[i].id;
      let cityName = cityList[i].name;
      let cityCountry = cityList[i].country;
      if (cityName.toUpperCase().startsWith(inputValue.value.toUpperCase())) {
        let item = document.createElement("DIV");
        item.setAttribute("class", "listItem");
        item.innerHTML = cityName + ", " + cityCountry;
        item.innerHTML += "<input type='hidden' value='" + cityId + "'>";
        item.innerHTML += "<input type='hidden' value='" + cityName + "'>";
        item.addEventListener("click", this.weatherOnClick);
        document.getElementById("autocomplete-list").appendChild(item);
      }
    }
  }

  weatherOnClick() {
    let cityId = this.getElementsByTagName("input")[0].value;
    let cityName = this.getElementsByTagName("input")[1].value;
    let inputView = document.getElementById("searchInput");
    let elements = document.getElementsByClassName("listItem");
    while (elements.length > 0) {
      elements[0].parentNode.removeChild(elements[0]);
    }
    inputView.value = cityName;
    let weatherClient = new WeatherClient();
    let weatherController = new WeatherController();
    weatherClient
      .getWeather(cityId)
      .then(
        function(result) {
          weatherController.showCity(result.name, result.sys.country);
          weatherController.showHumidity(result.main.humidity);
          weatherController.showTemperature(result.main.temp);
          weatherController.showWind(result.wind.speed);
          weatherController.showIcon(
            result.weather[0].icon,
            result.weather[0].description
          );
        },
        error => console.log(error)
      )
      .catch(error => console.log(error));
  }

  clearAutocompleteList() {
    let elements = document.getElementsByClassName("listItem");
    while (elements.length > 0) {
      elements[0].parentNode.removeChild(elements[0]);
    }
  }
}
