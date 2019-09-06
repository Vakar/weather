export default class WeatherClient {
  constructor() {
    this.webServiceGetWeatherByCityId = "rest/weather/getWeatherByCityId/";
  }
  getWeather(cityId) {
    let xhr = new XMLHttpRequest();
    xhr.open("GET", this.webServiceGetWeatherByCityId + cityId, true);
    let promise = new Promise(function(resolve, reject) {
      xhr.onload = function() {
        if (this.status == 200) {
          resolve(JSON.parse(xhr.responseText));
        } else {
          reject(new Error(`Can't get weather for city with id: ${cityId}!`));
        }
      };
    });
    xhr.send();
    return promise;
  }
}
