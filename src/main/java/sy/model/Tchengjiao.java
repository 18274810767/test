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
 * Tchengjiao entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tchengjiao", catalog = "fydb")
public class Tchengjiao implements java.io.Serializable {

	// Fields

	private String id;
	private Tuser tuser;
	private String customerName;
	private String fadeBack;
	private String isNotice;
	private String serviceContent;
	private String serviceMode;
	private Date createdatetime;
	private Date modifydatetime;

	// Constructors

	/** default constructor */
	public Tchengjiao() {
	}

	/** minimal constructor */
	public Tchengjiao(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tchengjiao(String id, Tuser tuser, String customerName,
			String fadeBack, String isNotice, String serviceContent,
			String serviceMode, Date createdatetime, Date modifydatetime) {
		this.id = id;
		this.tuser = tuser;
		this.customerName = customerName;
		this.fadeBack = fadeBack;
		this.isNotice = isNotice;
		this.serviceContent = serviceContent;
		this.serviceMode = serviceMode;
		this.createdatetime = createdatetime;
		this.modifydatetime = modifydatetime;
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
	@JoinColumn(name = "user_id")
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	@Column(name = "customerName", length = 50)
	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	@Column(name = "fadeBack", length = 500)
	public String getFadeBack() {
		return this.fadeBack;
	}

	public void setFadeBack(String fadeBack) {
		this.fadeBack = fadeBack;
	}

	@Column(name = "isNotice", length = 1)
	public String getIsNotice() {
		return this.isNotice;
	}

	public void setIsNotice(String isNotice) {
		this.isNotice = isNotice;
	}

	@Column(name = "serviceContent", length = 100)
	public String getServiceContent() {
		return this.serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	@Column(name = "serviceMode", length = 50)
	public String getServiceMode() {
		return this.serviceMode;
	}

	public void setServiceMode(String serviceMode) {
		this.serviceMode = serviceMode;
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

}