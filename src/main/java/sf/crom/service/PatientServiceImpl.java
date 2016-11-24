package sf.crom.service;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.ws.rs.core.Response;

import sf.crom.bo.Patient;

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

	public Patient getPatient(String id) {
		Logger.getLogger("Ptient Service log").info("In get patient " + id);
		Patient patient = patients.get(Long.parseLong(id));
		return patient;
	}

	public Response updatePatient(Patient patient) {
		Logger.getLogger("Ptient Service log").info(
				"Update patient " + patient.getId());
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response createPatient(Patient patient) {
		Logger.getLogger("Ptient Service log").info(
				"Create patient " + patient.getName());
		patientId = patientId + 1;
		patient.setId(patientId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response deletePatient(String id) {
		Logger.getLogger("Ptient Service log").info("Delete patient " + id);
		patients.remove(id);
		return Response.ok().build();
	}

}
