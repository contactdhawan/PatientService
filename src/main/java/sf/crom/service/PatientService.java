package sf.crom.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import sf.crom.bo.Patient;

@Produces({ "application/json,application/xml" })
public interface PatientService {
	@GET
	@Path("/patient/{patientID}")
	public Patient getPatient(@PathParam("patientID") Long id);
	
	@PUT
	@Path("/patient/")
	public Response updatePatient(Patient patient);
	
	@POST
	@Path("/patient/")
	public Response createPatient(Patient patient);
	
	@DELETE
	@Path("/patient/{patientID}")
	public Response deletePatient(@PathParam("patientID") Long id);
	
	
}
