package space.vakar.weather.domain.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class City implements Serializable {

  /** City id. */
  private int id;

  /** City name like "London". */
  private String name;

  /** Country code (GB, JP etc.) */
  private String country;
}
