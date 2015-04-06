package sy.pageModel;

import java.io.Serializable;

import sy.model.Tcustomer;

public class JiNianRi implements Serializable {
	
	private String id;
	private String customerId;
	private String brd;
	private String type;
	private String name;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBrd() {
		return brd;
	}
	public void setBrd(String brd) {
		this.brd = brd;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
