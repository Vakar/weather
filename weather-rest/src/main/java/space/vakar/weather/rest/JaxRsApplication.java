package space.vakar.weather.rest;

import org.glassfish.jersey.server.ResourceConfig;
import space.vakar.weather.rest.filter.CorsResponseFilter;

public class JaxRsApplication extends ResourceConfig {
  /** Register JAX-RS application components. */
  public JaxRsApplication() {
    register(CorsResponseFilter.class);
  }
}
