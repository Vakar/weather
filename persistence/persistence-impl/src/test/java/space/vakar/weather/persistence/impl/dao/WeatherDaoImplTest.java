package space.vakar.weather.persistence.impl.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import space.vakar.weather.persistence.api.weather.WeatherDao;
import space.vakar.weather.persistence.entities.weather.Weather;
import space.vakar.weather.persistence.test.config.JpaConfig;
import space.vakar.weather.persistence.util.WeatherPopulator;

import javax.annotation.Resource;

import static org.junit.Assert.fail;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JpaConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
public class WeatherDaoImplTest {

  @Resource
  private WeatherDao weatherDaoImpl;


  @Test
  public void testCreate() {
    Weather weather = new Weather();
    WeatherPopulator.populate(weather);
    weatherDaoImpl.create(weather);
    System.out.println("Hello");

  }

  @Test
  public void testRead() {
    fail("Not yet implemented");
  }

  @Test
  public void testUpdate() {
    fail("Not yet implemented");
  }

  @Test
  public void testDelete() {
    fail("Not yet implemented");
  }

}
