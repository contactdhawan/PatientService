package sf.crom.service;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import sf.crom.bo.Patient;

public class PatientServiceImplTest {
	PatientServiceImpl patientServiceImpl;
	Patient patient;

	@Before
	public void setup() {
		patientServiceImpl = new PatientServiceImpl();
		patient = new Patient();
		patient.setName("Test Patient");
		patient.setId(123);
	}

	@Test
	public void testCreatePatient() {
		Response createPatientResp = patientServiceImpl.createPatient(patient);
		assertEquals(200, createPatientResp.getStatus());
	}

	@Test
	public void testDeletePatient_should_return_200() {
		Patient newPatient = new Patient();
		newPatient.setName("Adding a patient to delete");
		Response createdPatientResp = patientServiceImpl
				.createPatient(newPatient);
		Patient createdPatient = (Patient) createdPatientResp.getEntity();
		Response deletePatientResp = patientServiceImpl
				.deletePatient(createdPatient.getId() + "");
		assertEquals(200, deletePatientResp.getStatus());
	}

	@Test
	public void testDeletePatient_should_return_304() {
		Response deletePatientResp = patientServiceImpl.deletePatient("567");
		assertEquals(304, deletePatientResp.getStatus());
	}

	@Test
	public void testUpdatePatient() {
		patient.setName("Updated Patient");
		Response updatedPatientResp = patientServiceImpl.updatePatient(patient);
		assertEquals(200, updatedPatientResp.getStatus());
	}

	@Test
	public void testUpdatePatient_shouldreturn_304() {
		Patient patientToBeUpdated = new Patient();
		patientToBeUpdated.setId(100);
		patientToBeUpdated.setName("Updated Patient");
		Response updatedPatientResp = patientServiceImpl
				.updatePatient(patientToBeUpdated);
		assertEquals(304, updatedPatientResp.getStatus());
	}

	@Test
	public void testGetPatient() {
		Patient getExistingPatient = patientServiceImpl.getPatient("123");
		assertNotNull(getExistingPatient);
	}
}
