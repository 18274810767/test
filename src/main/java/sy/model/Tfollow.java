package sy.model;

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
 * Tfollow entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tfollow", catalog = "fydb")
public class Tfollow implements java.io.Serializable {

	// Fields

	private String id;
	private Tcustomer tcustomer;
	private String type;
	private String remark;
	private String note;
	private Date createDatetime;
	private String isjihui;
	private String gcDescr;
	private String jgDescr;
	private String userId;
	private String isQiangdan;

	// Constructors

	/** default constructor */
	public Tfollow() {
	}

	/** minimal constructor */
	public Tfollow(String id, String remark) {
		this.id = id;
		this.remark = remark;
	}

	/** full constructor */
	public Tfollow(String id, Tcustomer tcustomer, String type, String remark,
			String note, Date createDatetime, String isjihui, String gcDescr,
			String jgDescr, String userId, String isQiangdan) {
		this.id = id;
		this.tcustomer = tcustomer;
		this.type = type;
		this.remark = remark;
		this.note = note;
		this.createDatetime = createDatetime;
		this.isjihui = isjihui;
		this.gcDescr = gcDescr;
		this.jgDescr = jgDescr;
		this.userId = userId;
		this.isQiangdan = isQiangdan;
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

	@Column(name = "type", length = 36)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "remark", nullable = false, length = 65535)
	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Column(name = "note")
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createDatetime", length = 10)
	public Date getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}

	@Column(name = "isjihui", length = 36)
	public String getIsjihui() {
		return this.isjihui;
	}

	public void setIsjihui(String isjihui) {
		this.isjihui = isjihui;
	}

	@Column(name = "gcDescr", length = 65535)
	public String getGcDescr() {
		return this.gcDescr;
	}

	public void setGcDescr(String gcDescr) {
		this.gcDescr = gcDescr;
	}

	@Column(name = "jgDescr", length = 65535)
	public String getJgDescr() {
		return this.jgDescr;
	}

	public void setJgDescr(String jgDescr) {
		this.jgDescr = jgDescr;
	}

	@Column(name = "user_id", length = 36)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "isQiangdan", length = 36)
	public String getIsQiangdan() {
		return this.isQiangdan;
	}

	public void setIsQiangdan(String isQiangdan) {
		this.isQiangdan = isQiangdan;
	}

}