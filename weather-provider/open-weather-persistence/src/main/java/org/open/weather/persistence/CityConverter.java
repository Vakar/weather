package org.open.weather.persistence;

import space.vakar.weather.domain.model.City;

class CityConverter {

  private CityConverter() {

  }

  static City convert(DtoCity dto) {
    return new City(dto.getId(), dto.getName(), dto.getCountry());
  }

}
