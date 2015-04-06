package sy.model;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tbug entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbug", catalog = "fydb")
public class Tbug implements java.io.Serializable {

	// Fields

	private String id;
	private Tbugtype tbugtype;
	private Date createdatetime;
	private Date modifydatetime;
	private String name;
	private Clob note;

	// Constructors

	/** default constructor */
	public Tbug() {
	}

	/** minimal constructor */
	public Tbug(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tbug(String id, Tbugtype tbugtype, Date createdatetime,
			Date modifydatetime, String name, Clob note) {
		this.id = id;
		this.tbugtype = tbugtype;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
		this.name = name;
		this.note = note;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "BUGTYPE_ID")
	public Tbugtype getTbugtype() {
		return this.tbugtype;
	}

	public void setTbugtype(Tbugtype tbugtype) {
		this.tbugtype = tbugtype;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATETIME", length = 10)
	public Date getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATETIME", length = 10)
	public Date getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "NOTE")
	public Clob getNote() {
		return this.note;
	}

	public void setNote(Clob note) {
		this.note = note;
	}

}