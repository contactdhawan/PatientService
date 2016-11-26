package sf.crom.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class BusinessMapper implements ExceptionMapper<SomeBusinessException> {

	@Override
	public Response toResponse(SomeBusinessException e) {
		StringBuffer responseMessage = new StringBuffer();
		responseMessage.append("<response>");
		String message = "<message>" + e.getMessage() + "</message>";
		responseMessage.append(message);
		responseMessage.append("</response>");
		return Response.serverError().entity(responseMessage.toString()).type(MediaType.APPLICATION_XML).build();
	}

}
