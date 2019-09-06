export default class Converter {
  static kelvinToFahrenheit(kelvin) {
    let celsius = this.kelvinToCelsius(kelvin);
    return celsius * (9 / 5) + 32;
  }

  static kelvinToCelsius(kelvin) {
    return kelvin - 273.15;
  }
}
