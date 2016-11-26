package sf.crom.service;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import sf.crom.bo.Patient;

/**
 * @author nk839683
 *
 */
/**
 * @author nk839683
 *
 */
/**
 * @author nk839683
 *
 */
public class PatientServiceImpl implements PatientService {
	long patientId = 123;
	HashMap<Long, Patient> patients;

	public PatientServiceImpl() {
		init();
	}

	public void init() {
		patients = new HashMap<>();
		Patient firstPatient = new Patient();
		firstPatient.setId(patientId);
		firstPatient.setName("First Patient");
		patients.put(firstPatient.getId(), firstPatient);
	}

	public Patient getPatient(final Long id) {
		Logger.getLogger("Patient Service log").info("In get patient " + id);
		Patient patient = patients.get(id);
		return patient;
	}

	public Response updatePatient(final Patient patient) {
		Logger.getLogger("Patient Service log").info(
				"Update patient " + patient.getId());
		Response response;
		if (patients.get(patient.getId()) != null) {
			patients.put(patient.getId(), patient);
			response = Response.ok(patient).build();
		}else{
			response = Response.notModified().build();
		}
		return response;
	}

	@Override
	public Response createPatient(final Patient patient) {
		Logger.getLogger("Patient Service log").info(
				"Create patient " + patient.getName());
		patientId = patientId + 1;
		patient.setId(patientId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response deletePatient(final Long id) {
		Logger.getLogger("Patient Service log").info("Delete patient " + id);
		Patient patient = patients.get(id);
		Response response;
		if (patient != null) {
			patients.remove(id);
			response = Response.ok().build();
		} else {
			response = Response.notModified().build();
		}
		return response;
	}

}
