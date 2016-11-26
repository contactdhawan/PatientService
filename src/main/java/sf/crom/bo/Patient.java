package sf.crom.bo;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author nk839683
 * 
 */
@XmlRootElement
public class Patient {
	private long id;
	private String name;

	/**
	 * 
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setId(final long idParam) {
		this.id = idParam;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(final String nameParam) {
		this.name = nameParam;
	}
}
