package space.vakar.weather.open.weather.util.adapters;

import space.vakar.weather.domain.model.weather.temperature.TemperatureUnit;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class TemperatureUnitAdapter extends XmlAdapter<String, TemperatureUnit> {

  @Override
  public String marshal(TemperatureUnit unit) throws Exception {
    return unit.name().toLowerCase();
  }

  @Override
  public TemperatureUnit unmarshal(String unit) throws Exception {
    return TemperatureUnit.valueOf(unit.toUpperCase());
  }
}