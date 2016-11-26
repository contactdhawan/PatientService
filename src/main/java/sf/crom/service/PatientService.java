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
import sf.crom.bo.Prescription;

/**
 * @author nk839683
 * 
 */
@Produces({ "application/json,application/xml" })
public interface PatientService {
	@GET
	@Path("/patient/{patientID}")
	Patient getPatient(@PathParam("patientID") final Long id);

	@PUT
	@Path("/patient/")
	Response updatePatient(final Patient patient);

	@POST
	@Path("/patient/")
	Response createPatient(final Patient patient);

	@DELETE
	@Path("/patient/{patientID}")
	Response deletePatient(@PathParam("patientID") final Long id);

	@Path("/prescription/{prescriptionId}")
	Prescription getPrescription(
			@PathParam("prescriptionId") final Long prescriptionId);

}
