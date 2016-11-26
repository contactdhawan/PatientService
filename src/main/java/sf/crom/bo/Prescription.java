package sf.crom.bo;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Prescription {
	private long id;
	private String description;
	Map<Long, Medicine> medicines;

	public Prescription() {
		medicines = new HashMap<Long, Medicine>();
		Medicine medicine = new Medicine();
		medicine.setId(433L);
		medicine.setDescription("Medicine description");
		medicines.put(433L, medicine);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@GET
	@Path("/medicine/{medicineId}")
	public Response getMedicine(@PathParam("medicineId") Long medicineID) {
		Medicine medicine = medicines.get(medicineID);
		if (medicine != null) {
			return Response.ok(medicine).build();
		}else{
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
	}
}
