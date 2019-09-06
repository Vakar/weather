// IMPORT CONTROLLERS
import CityListController from "./controllers/CityListController.js";
import MessageController from "./controllers/MessageController.js";
import WeatherController from "./controllers/WeatherController.js";
// IMPORT CLIENTS
import CityClient from "./clients/CityClient.js";

// VIEWS: DOM elements

// Controller objects
const cityListController = new CityListController();
const messageController = new MessageController();
const weatherController = new WeatherController();
// Client objects
const cityClient = new CityClient();

document
  .getElementById("citySearch")
  .addEventListener("submit", searchButtonListener);

function searchButtonListener(event) {
  event.preventDefault();
  let inputView = document.getElementById("searchInput");
  let inputString = inputView.value.trim();
  inputView.value = inputString;
  if (isEmpty(inputString)) {
    messageController.showMessage("City name should not be blank!");
  } else {
    messageController.eraseMessage();
    cityClient
      .findCities(inputString)
      .then(
        function(result) {
          if (result.length == 0) {
            weatherController.cleanWeather();
            messageController.showMessage(
              `Can't find any city with name ${inputString}!`
            );
          } else {
            cityListController.showAutocompleteList(result);
          }
        },
        error => console.log(error)
      )
      .catch(error => console.log(error));
  }
}

function isEmpty(str) {
  return !str || 0 === str.length;
}

document.addEventListener("click", cityListController.clearAutocompleteList);
