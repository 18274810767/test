package sy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Tuser entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tuser", catalog = "fydb", uniqueConstraints = @UniqueConstraint(columnNames = "NAME"))
public class Tuser implements java.io.Serializable {

	// Fields

	private String id;
	private Tsolarytype tsolarytype;
	private Torganization torganization;
	private String adr;
	private Date brd;
	private Integer brdType;
	private String cardNum;
	private Date createdatetime;
	private String gcode;
	private Date modifydatetime;
	private String name;
	private String pwd;
	private String realname;
	private Date ruzhidate;
	private String tuijianren;
	private String zhiwu;
	private Set<Tchengjiao> tchengjiaos = new HashSet<Tchengjiao>(0);
	private Set<Trole> troles = new HashSet<Trole>(0);
	private Set<Tcustomer> tcustomers = new HashSet<Tcustomer>(0);

	// Constructors

	/** default constructor */
	public Tuser() {
	}

	/** minimal constructor */
	public Tuser(String id, String name, String pwd) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}

	/** full constructor */
	public Tuser(String id, Tsolarytype tsolarytype,
			Torganization torganization, String adr, Date brd, Integer brdType,
			String cardNum, Date createdatetime, String gcode,
			Date modifydatetime, String name, String pwd, String realname,
			Date ruzhidate, String tuijianren, String zhiwu,
			Set<Tchengjiao> tchengjiaos, Set<Trole> troles,
			Set<Tcustomer> tcustomers) {
		this.id = id;
		this.tsolarytype = tsolarytype;
		this.torganization = torganization;
		this.adr = adr;
		this.brd = brd;
		this.brdType = brdType;
		this.cardNum = cardNum;
		this.createdatetime = createdatetime;
		this.gcode = gcode;
		this.modifydatetime = modifydatetime;
		this.name = name;
		this.pwd = pwd;
		this.realname = realname;
		this.ruzhidate = ruzhidate;
		this.tuijianren = tuijianren;
		this.zhiwu = zhiwu;
		this.tchengjiaos = tchengjiaos;
		this.troles = troles;
		this.tcustomers = tcustomers;
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
	@JoinColumn(name = "SOLARYTYPE_ID")
	public Tsolarytype getTsolarytype() {
		return this.tsolarytype;
	}

	public void setTsolarytype(Tsolarytype tsolarytype) {
		this.tsolarytype = tsolarytype;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ORGANIZATION_ID")
	public Torganization getTorganization() {
		return this.torganization;
	}

	public void setTorganization(Torganization torganization) {
		this.torganization = torganization;
	}

	@Column(name = "ADR", length = 200)
	public String getAdr() {
		return this.adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BRD", length = 10)
	public Date getBrd() {
		return this.brd;
	}

	public void setBrd(Date brd) {
		this.brd = brd;
	}

	@Column(name = "BRD_TYPE")
	public Integer getBrdType() {
		return this.brdType;
	}

	public void setBrdType(Integer brdType) {
		this.brdType = brdType;
	}

	@Column(name = "CARD_NUM", length = 50)
	public String getCardNum() {
		return this.cardNum;
	}

	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATETIME", length = 10)
	public Date getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Column(name = "GCODE", length = 36)
	public String getGcode() {
		return this.gcode;
	}

	public void setGcode(String gcode) {
		this.gcode = gcode;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATETIME", length = 10)
	public Date getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

	@Column(name = "NAME", unique = true, nullable = false, length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "PWD", nullable = false, length = 100)
	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Column(name = "REALNAME", length = 100)
	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "RUZHIDATE", length = 10)
	public Date getRuzhidate() {
		return this.ruzhidate;
	}

	public void setRuzhidate(Date ruzhidate) {
		this.ruzhidate = ruzhidate;
	}

	@Column(name = "TUIJIANREN", length = 50)
	public String getTuijianren() {
		return this.tuijianren;
	}

	public void setTuijianren(String tuijianren) {
		this.tuijianren = tuijianren;
	}

	@Column(name = "ZHIWU", length = 50)
	public String getZhiwu() {
		return this.zhiwu;
	}

	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Tchengjiao> getTchengjiaos() {
		return this.tchengjiaos;
	}

	public void setTchengjiaos(Set<Tchengjiao> tchengjiaos) {
		this.tchengjiaos = tchengjiaos;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tuser_trole", catalog = "fydb", joinColumns = { @JoinColumn(name = "TUSER_ID", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "TROLE_ID", nullable = false, updatable = false) })
	public Set<Trole> getTroles() {
		return this.troles;
	}

	public void setTroles(Set<Trole> troles) {
		this.troles = troles;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tuser")
	public Set<Tcustomer> getTcustomers() {
		return this.tcustomers;
	}

	public void setTcustomers(Set<Tcustomer> tcustomers) {
		this.tcustomers = tcustomers;
	}

}