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
	public void setup(){
		patientServiceImpl = new PatientServiceImpl();
		patient = new Patient();
		patient.setName("Test Patient");
	}

	@Test
	public void testCreatePatient() {
		Response createPatientResp = patientServiceImpl.createPatient(patient);
		assertEquals(200,createPatientResp.getStatus());
	}

	@Test
	public void testDeletePatient_should_return_200(){
		Response deletePatientResp = patientServiceImpl.deletePatient("123");
		assertEquals(200,deletePatientResp.getStatus());
	}
	
	@Test
	public void testDeletePatient_should_return_304(){
		Response deletePatientResp = patientServiceImpl.deletePatient("567");
		assertEquals(304,deletePatientResp.getStatus());
	}
}
