package sf.crom.bo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Patient {
long id;
String name;
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
}
