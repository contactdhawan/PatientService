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
		System.out.println("In get patient " + id);
		Logger.getLogger("Ptient Service log").info("In get patient " + id);
		Patient patient = patients.get(Long.parseLong(id));
		return patient;
	}

	public Response updatePatient(Patient patient) {
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response createPatient(Patient patient) {
		patientId = patientId + 1;
		patient.setId(patientId);
		patients.put(patient.getId(), patient);
		return Response.ok(patient).build();
	}

	@Override
	public Response deletePatient(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
