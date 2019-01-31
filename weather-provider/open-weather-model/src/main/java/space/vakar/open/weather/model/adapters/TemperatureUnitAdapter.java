package space.vakar.open.weather.model.adapters;

import space.vakar.weather.domain.model.weather.temperature.TemperatureUnit;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TemperatureUnitAdapter extends XmlAdapter<String, TemperatureUnit> {

  @Override
  public String marshal(TemperatureUnit unit) {
    return unit.name().toLowerCase();
  }

  @Override
  public TemperatureUnit unmarshal(String unit) {
    return TemperatureUnit.valueOf(unit.toUpperCase());
  }
}
