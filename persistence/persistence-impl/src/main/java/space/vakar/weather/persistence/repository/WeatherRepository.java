package space.vakar.weather.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import space.vakar.weather.persistence.entities.weather.Weather;

public interface WeatherRepository extends JpaRepository<Weather, Long> {

}
