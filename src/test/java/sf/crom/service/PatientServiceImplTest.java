package sf.crom.service;

import static org.junit.Assert.*;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;

import sf.crom.bo.Patient;
import sf.crom.exception.SomeBusinessException;

public class PatientServiceImplTest {
	PatientServiceImpl patientServiceImpl;
	Patient patient;

	@Before
	public void setup() {
		patientServiceImpl = new PatientServiceImpl();
		patient = new Patient();
		patient.setName("Test Patient");
		patient.setId(123L);
	}

	@Test
	public void testCreatePatient()  {
		Response createPatientResp = patientServiceImpl.createPatient(patient);
		assertEquals(200, createPatientResp.getStatus());
	}

	@Test
	public void testDeletePatient_should_return_200() throws Exception{
		Patient newPatient = new Patient();
		newPatient.setName("Adding a patient to delete");
		Response createdPatientResp = patientServiceImpl
				.createPatient(newPatient);
		Patient createdPatient = (Patient) createdPatientResp.getEntity();
		Response deletePatientResp = patientServiceImpl
				.deletePatient(createdPatient.getId());
		assertEquals(200, deletePatientResp.getStatus());
		Thread.sleep(2000);
	}

	@Test(expected=SomeBusinessException.class)
	public void testDeletePatient_should_return_exception() throws Exception {
		patientServiceImpl.deletePatient(567L);
		//assertEquals(304, deletePatientResp.getStatus());
		Thread.sleep(2000);
	}

	@Test
	public void testUpdatePatient() throws Exception {
		Patient testPatient = new Patient();
		testPatient.setName("testPatient3");
		Response createPatient = patientServiceImpl.createPatient(testPatient);
		Patient createdPatient = (Patient) createPatient.getEntity();
		Patient getExistingPatient = patientServiceImpl
				.getPatient(createdPatient.getId());

		getExistingPatient.setName("Updated Patient");

		Response updatedPatientResp = patientServiceImpl
				.updatePatient(getExistingPatient);
		assertEquals(200, updatedPatientResp.getStatus());
		Thread.sleep(2000);
	}

	@Test(expected = NotFoundException.class)
	public void testUpdatePatient_shouldreturn_304() throws Exception {
		Patient patientToBeUpdated = new Patient();
		patientToBeUpdated.setId(100);
		patientToBeUpdated.setName("Updated Patient");
		patientServiceImpl.updatePatient(patientToBeUpdated);
		Thread.sleep(2000);
		// assertEquals(304, updatedPatientResp.getStatus());
	}

	@Test
	public void testGetPatient() throws Exception {
		// first create patient and then get
		Patient testPatient = new Patient();
		testPatient.setName("testPatient2");
		Response createPatient = patientServiceImpl.createPatient(testPatient);
		Patient createdPatient = (Patient) createPatient.getEntity();
		Patient getExistingPatient = patientServiceImpl
				.getPatient(createdPatient.getId());
		assertNotNull(getExistingPatient);
		Thread.sleep(2000);
	}
}
