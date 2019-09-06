export default class CityClient {
  constructor() {
    this.webServiceGetCitiesByName = "rest/city/getCitiesByName/";
  }
  findCities(inputString) {
    let xhr = new XMLHttpRequest();
    console.log(this.webServiceGetCitiesByName + inputString);
    xhr.open("GET", this.webServiceGetCitiesByName + inputString, true);
    let promise = new Promise(function(resolve, reject) {
      xhr.onload = function() {
        if (this.status == 200) {
          resolve(JSON.parse(xhr.responseText));
        } else {
          reject(new Error(`Can't get city: ${inputString}`));
        }
      };
    });
    xhr.send();
    return promise;
  }
}
