package sy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Tjinianri entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tjinianri", catalog = "fydb")
public class Tjinianri implements java.io.Serializable {

	// Fields

	private String id;
	private Tcustomer tcustomer;
	private String brd;
	private String type;
	private String name;

	// Constructors

	/** default constructor */
	public Tjinianri() {
	}

	/** minimal constructor */
	public Tjinianri(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tjinianri(String id, Tcustomer tcustomer, String brd, String type,
			String name) {
		this.id = id;
		this.tcustomer = tcustomer;
		this.brd = brd;
		this.type = type;
		this.name = name;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	public Tcustomer getTcustomer() {
		return this.tcustomer;
	}

	public void setTcustomer(Tcustomer tcustomer) {
		this.tcustomer = tcustomer;
	}

	@Column(name = "brd")
	public String getBrd() {
		return this.brd;
	}

	public void setBrd(String brd) {
		this.brd = brd;
	}

	@Column(name = "type", length = 36)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "name")
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}