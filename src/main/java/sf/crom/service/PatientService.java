package sf.crom.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import sf.crom.bo.Patient;

@Produces({ "application/json,application/xml" })
public interface PatientService {
	@GET
	@Path("/patient/{patientID}")
	public Patient getPatient(@PathParam("patientID") String id);
}
