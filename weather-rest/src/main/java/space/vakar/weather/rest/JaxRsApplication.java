package space.vakar.weather.rest;

import org.glassfish.jersey.server.ResourceConfig;
import space.vakar.weather.rest.filter.CORSResponseFilter;

public class JaxRsApplication extends ResourceConfig {
  /** Register JAX-RS application components. */
  public JaxRsApplication() {
    packages("space.vakar.weather.rest");
    register(CORSResponseFilter.class);
  }
}
