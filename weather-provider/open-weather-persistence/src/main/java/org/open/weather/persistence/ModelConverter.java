package org.open.weather.persistence;

import space.vakar.weather.domain.model.City;

class ModelConverter {

  private ModelConverter() {}

  static City getFrom(EntityCity entity) {
    int id = entity.getId();
    String name = entity.getName();
    String country = entity.getCountry();
    return new City(id, name, country);
  }

}
