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
 * Tsolarytype entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tsolarytype", catalog = "fydb")
public class Tsolarytype implements java.io.Serializable {

	// Fields

	private String level;
	private Integer baseGz;
	private String bz;
	private Integer gdGz;
	private Double gt;
	private Integer jxGz;
	private String name;
	private Set<Tuser> tusers = new HashSet<Tuser>(0);

	// Constructors

	/** default constructor */
	public Tsolarytype() {
	}

	/** minimal constructor */
	public Tsolarytype(String level) {
		this.level = level;
	}

	/** full constructor */
	public Tsolarytype(String level, Integer baseGz, String bz, Integer gdGz,
			Double gt, Integer jxGz, String name, Set<Tuser> tusers) {
		this.level = level;
		this.baseGz = baseGz;
		this.bz = bz;
		this.gdGz = gdGz;
		this.gt = gt;
		this.jxGz = jxGz;
		this.name = name;
		this.tusers = tusers;
	}

	// Property accessors
	@Id
	@Column(name = "LEVEL", unique = true, nullable = false, length = 50)
	public String getLevel() {
		return this.level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Column(name = "BASE_GZ")
	public Integer getBaseGz() {
		return this.baseGz;
	}

	public void setBaseGz(Integer baseGz) {
		this.baseGz = baseGz;
	}

	@Column(name = "BZ", length = 200)
	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	@Column(name = "GD_GZ")
	public Integer getGdGz() {
		return this.gdGz;
	}

	public void setGdGz(Integer gdGz) {
		this.gdGz = gdGz;
	}

	@Column(name = "GT", precision = 22, scale = 0)
	public Double getGt() {
		return this.gt;
	}

	public void setGt(Double gt) {
		this.gt = gt;
	}

	@Column(name = "JX_GZ")
	public Integer getJxGz() {
		return this.jxGz;
	}

	public void setJxGz(Integer jxGz) {
		this.jxGz = jxGz;
	}

	@Column(name = "NAME", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tsolarytype")
	public Set<Tuser> getTusers() {
		return this.tusers;
	}

	public void setTusers(Set<Tuser> tusers) {
		this.tusers = tusers;
	}

}