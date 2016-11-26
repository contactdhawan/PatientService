package sf.crom.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import sf.crom.bo.Patient;

public class ParientServiceClient {
	
	//private static final String patientURL = "http://52.43.245.145:8888/patientservice-svc/services/patientService/";
	private static final String patientURL = "http://localhost:8090/patientservice-svc/services/patientService/";
	public static void main(String args[]) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client
				.target(patientURL).path("/patient").path("/{patientID}").resolveTemplate("patientID", 123L);
		Patient patient = target.request().get(Patient.class);
		System.out.println(patient.getName());
	}
}
