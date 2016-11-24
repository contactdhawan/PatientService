package sf.crom.service;

import java.util.HashMap;

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
		Patient patient = patients.get(id);
		return patient;
	}

}
