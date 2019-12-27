package space.vakar.weather.rest.exception.handler;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

@Produces("text/html; charset=UTF-8")
public class UncaughtException extends Throwable implements ExceptionMapper<Throwable> {
  private static final long serialVersionUID = 1L;

  @Override
  public Response toResponse(Throwable exception) {
    return Response.status(500)
        .entity("Something bad happened. Please try again !!!")
        .type("text/plain")
        .build();
  }
}
