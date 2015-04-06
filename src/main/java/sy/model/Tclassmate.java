package sy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tclassmate", catalog = "fydb")
public class Tclassmate implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private String slogan;
	private String classActivity;
	private String member;

	// Constructors

	/** default constructor */
	public Tclassmate() {
	}

	/** minimal constructor */
	public Tclassmate(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tclassmate(String id, String name, String slogan,
			String classActivity, String member) {
		this.id = id;
		this.name = name;
		this.slogan = slogan;
		this.classActivity = classActivity;
		this.member = member;
	}

	// Property accessors
	@Id
	@Column(name = "id", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "slogan")
	public String getSlogan() {
		return this.slogan;
	}

	public void setSlogan(String slogan) {
		this.slogan = slogan;
	}

	@Column(name = "classActivity")
	public String getClassActivity() {
		return this.classActivity;
	}

	public void setClassActivity(String classActivity) {
		this.classActivity = classActivity;
	}

	@Column(name = "member")
	public String getMember() {
		return this.member;
	}

	public void setMember(String member) {
		this.member = member;
	}

}