package sf.crom.service;

import java.util.HashMap;
import java.util.logging.Logger;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import sf.crom.bo.Patient;
import sf.crom.bo.Prescription;

/**
 * @author nk839683
 * 
 */
public class PatientServiceImpl implements PatientService {
	private static long patientId = 123L;
	private static long prescriptionId = 323L;
	private HashMap<Long, Patient> patients;
	private HashMap<Long, Prescription> prescriptions;

	public PatientServiceImpl() {
		init();
	}

	public void init() {
		patients = new HashMap<>();
		Patient firstPatient = new Patient();
		firstPatient.setId(patientId);
		firstPatient.setName("First Patient");
		patients.put(firstPatient.getId(), firstPatient);

		prescriptions = new HashMap<>();
		Prescription prescription = new Prescription();
		prescription.setId(prescriptionId);
		prescription.setDescription("Prescription Description");
		prescriptions.put(prescriptionId, prescription);
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
		if (getPatients().get(patient.getId()) != null) {
			getPatients().put(patient.getId(), patient);
			response = Response.ok(patient).build();
		} else {
			//response = Response.notModified().build();
			throw new NotFoundException();
		}
		return response;
	}

	@Override
	public Response createPatient(final Patient patient) {
		Logger.getLogger("Patient Service log").info(
				"Create patient " + patient.getName());
		Long newPatientId = getPatientId() + 1;
		setPatientId(newPatientId);
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

	public static long getPatientId() {
		return patientId;
	}

	public static void setPatientId(long patientId) {
		PatientServiceImpl.patientId = patientId;
	}

	public HashMap<Long, Patient> getPatients() {
		return patients;
	}

	public void setPatients(HashMap<Long, Patient> patients) {
		this.patients = patients;
	}

	@Override
	public Prescription getPrescription(Long prescriptionId) {
		Prescription myprescription = prescriptions.get(prescriptionId);
		
		return myprescription;
	}

}
