package sf.crom.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Produces({ "application/json,application/xml" })
public class PatientService {
	@GET
	@Path("/get/{key}")
	public Response getValue(@PathParam("key") String key) {
		return Response.ok(key).build();
	}

}
