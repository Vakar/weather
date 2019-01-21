package space.vakar.weather.persistence.impl.dao;

import org.springframework.stereotype.Repository;
import space.vakar.weather.persistence.api.weather.WeatherDao;
import space.vakar.weather.persistence.entities.weather.Weather;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class WeatherDaoImpl implements WeatherDao<Weather> {

  @PersistenceContext
  private EntityManager entityManager;

  @Override
  public Weather findOne(long id) {
    return entityManager.find(Weather.class, id);
  }

  @Override
  public List<Weather> findAll() {
    return entityManager.createQuery("from " + Weather.class).getResultList();
  }

  @Override
  public void create(Weather entity) {
    entityManager.persist(entity);
  }

  @Override
  public Weather update(Weather entity) {
    return entityManager.merge(entity);
  }

  @Override
  public void delete(Weather entity) {
    entityManager.remove(entity);
  }

  @Override
  public void deleteById(long entityId) {
    final Weather entity = findOne(entityId);
    delete(entity);
  }

}
