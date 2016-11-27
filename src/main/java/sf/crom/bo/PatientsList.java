package sf.crom.bo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class PatientsList {
	List<Patient> patients;

	public PatientsList() {
		init();
	}

	public void init() {
		patients = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			Patient patient = new Patient();
			patient.setId(100 + i);
			patient.setName("Patient # " + i);
			patients.add(patient);
		}
	}

	public List<Patient> getPatientsList() {
		return patients;
	}

	public void setPatientsList(List<Patient> patients) {
		this.patients = patients;
	}

}
