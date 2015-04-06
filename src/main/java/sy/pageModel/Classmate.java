package sy.pageModel;

import java.io.Serializable;

public class Classmate implements Serializable {
	
	private String id;
	private String name;
	private String slogan;
	private String classActivity;
	private String member;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSlogan() {
		return slogan;
	}
	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}
	public String getClassActivity() {
		return classActivity;
	}
	public void setClassActivity(String classActivity) {
		this.classActivity = classActivity;
	}
	public String getMember() {
		return member;
	}
	public void setMember(String member) {
		this.member = member;
	}
	
}
