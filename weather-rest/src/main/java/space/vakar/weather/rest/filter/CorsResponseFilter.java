package space.vakar.weather.rest.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/** This filter class add Cross-Origin Resource Sharing headers for HTTP server response. */
public class CorsResponseFilter implements ContainerResponseFilter {

  /**
   * This method add Cross-Origin Resource Sharing headers for HTTP server response.
   *
   * @param requestContext client request
   * @param responseContext server response
   */
  public void filter(
      ContainerRequestContext requestContext, ContainerResponseContext responseContext) {
    MultivaluedMap<String, Object> headers = responseContext.getHeaders();
    headers.add("Access-Control-Allow-Origin", "*");
    headers.add("Access-Control-Allow-Methods", "GET");
    headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
  }
}
