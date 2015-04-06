package sy.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Torganization entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "torganization", catalog = "fydb")
public class Torganization implements java.io.Serializable {

	// Fields

	private String id;
	private Torganization torganization;
	private String name;
	private Double tc;
	private String note;
	private String remark;
	private Integer seq;
	private Set<Torganization> torganizations = new HashSet<Torganization>(0);
	private Set<Tuser> tusers = new HashSet<Tuser>(0);

	// Constructors

	/** default constructor */
	public Torganization() {
	}

	/** minimal constructor */
	public Torganization(String id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public Torganization(String id, Torganization torganization, String name,
			Double tc, String note, String remark, Integer seq,
			Set<Torganization> torganizations, Set<Tuser> tusers) {
		this.id = id;
		this.torganization = torganization;
		this.name = name;
		this.tc = tc;
		this.note = note;
		this.remark = remark;
		this.seq = seq;
		this.torganizations = torganizations;
		this.tusers = tusers;
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
	@JoinColumn(name = "pid")
	public Torganization getTorganization() {
		return this.torganization;
	}

	public void setTorganization(Torganization torganization) {
		this.torganization = torganization;
	}

	@Column(name = "name", nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "tc", precision = 22, scale = 0)
	public Double getTc() {
		return this.tc;
	}

	public void setTc(Double tc) {
		this.tc = tc;
	}

	@Column(name = "note", length = 36)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "remark")
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "seq")
	public Integer getSeq() {
		return this.seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "torganization")
	public Set<Torganization> getTorganizations() {
		return this.torganizations;
	}

	public void setTorganizations(Set<Torganization> torganizations) {
		this.torganizations = torganizations;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "torganization")
	public Set<Tuser> getTusers() {
		return this.tusers;
	}

	public void setTusers(Set<Tuser> tusers) {
		this.tusers = tusers;
	}

}