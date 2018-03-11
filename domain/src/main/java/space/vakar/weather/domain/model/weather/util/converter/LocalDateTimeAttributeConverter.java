package space.vakar.weather.domain.model.weather.util.converter;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateTimeAttributeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(LocalDateTime arg0) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocalDateTime convertToEntityAttribute(Timestamp arg0) {
    // TODO Auto-generated method stub
    return null;
  }


}
