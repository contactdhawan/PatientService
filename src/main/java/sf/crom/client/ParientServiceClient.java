package sf.crom.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import sf.crom.bo.Patient;

public class ParientServiceClient {
	public static final String baseURL = "http://52.43.245.145:8888/patientservice-svc/services/patientService/";

	public static void main(String rags[]) {
		Client client = ClientBuilder.newClient();
		createPatient(client);
		getPatient(client);
		updatePatient(client);
		deletePatient(client);
	}
	
	public static void deletePatient(Client client){
		WebTarget deleteWebTarget = client.target(baseURL).path("/patient/{patientId}").resolveTemplate("patientId", 123L);
		Response deleteResponse = deleteWebTarget.request().delete();
		System.out.println("Delete response status "+deleteResponse.getStatus());
	}
	
	public static void createPatient(Client client){
		Patient patient = new Patient();
		patient.setName("New Patient");
		WebTarget postWebTarget = client.target(baseURL).path("/patient");
		Patient newPatient = postWebTarget.request().post(Entity.entity(patient, MediaType.APPLICATION_XML),Patient.class);
		System.out.println("Post response status "+newPatient.getId()+"\t"+newPatient.getName());
	}
	
	public static void updatePatient(Client client){
		//get the patient first
		WebTarget getWebTarget = client.target(baseURL).path("/patient/{patientID}").resolveTemplate("patientID", 123L);
		Patient patient = getWebTarget.request(MediaType.APPLICATION_XML).get(Patient.class);
		System.out.println("Patient name before update "+patient.getName());
		//then update the patient
		patient.setName("Updated patient");
		WebTarget putWebTarget = client.target(baseURL).path("/patient");
		Response putResponse = putWebTarget.request().put(Entity.entity(patient, MediaType.APPLICATION_XML));
		System.out.println("Put response status "+putResponse.getStatus());
		
		
	}
	

	public static void getPatient(Client client) {
		WebTarget getWebTarget = client.target(baseURL)
				.path("/patient/{patientID}")
				.resolveTemplate("patientID", 123L);
		Response response = getWebTarget.request().get();
		System.out.println("Get patient response status "+response.getStatus());
	}
}
