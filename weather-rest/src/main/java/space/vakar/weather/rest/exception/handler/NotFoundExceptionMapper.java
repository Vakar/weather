package space.vakar.weather.rest.exception.handler;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/** This provider class intercepts requests to unknown resource. */
@Provider
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

  /**
   * This method provide server response when client request to unknown resource.
   *
   * @param exception not found resource exception
   * @return response to client with basic error information
   */
  public Response toResponse(NotFoundException exception) {
    return Response.status(Response.Status.NOT_FOUND)
        .entity("404: No such resource.")
        .type("text/html; charset=UTF-8")
        .build();
  }
}
