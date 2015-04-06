package sy.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tbugtype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tbugtype", catalog = "fydb")
public class Tbugtype implements java.io.Serializable {

	// Fields

	private String id;
	private String name;
	private Set<Tbug> tbugs = new HashSet<Tbug>(0);

	// Constructors

	/** default constructor */
	public Tbugtype() {
	}

	/** minimal constructor */
	public Tbugtype(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tbugtype(String id, String name, Set<Tbug> tbugs) {
		this.id = id;
		this.name = name;
		this.tbugs = tbugs;
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

	@Column(name = "NAME", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tbugtype")
	public Set<Tbug> getTbugs() {
		return this.tbugs;
	}

	public void setTbugs(Set<Tbug> tbugs) {
		this.tbugs = tbugs;
	}

}