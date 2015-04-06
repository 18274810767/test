package sy.pageModel;

import java.util.Date;

import sy.model.Torganization;
import sy.model.Tsolarytype;

public class User implements java.io.Serializable {

	private String id;
	private String gcode;
	private String cardNum;
	private String zhiwu;
	private Date ruzhidate;
	private String tuijianren;
	private String adr;
	private Integer brdType;
	private Date createdatetime;
	private Date modifydatetime;
	private String name;
	private String pwd;
	private String realname;
	private Date brd;

	private Date createdatetimeStart;
	private Date createdatetimeEnd;
	private Date modifydatetimeStart;
	private Date modifydatetimeEnd;

	private String roleIds;
	private String roleNames;

	private String organizationId;
	private String organizationName;
	
	private String bz;
	private String solaryTypeId;
	
	private Integer customerNum;
	
	public Integer getCustomerNum() {
		return customerNum;
	}
	public void setCustomerNum(Integer customerNum) {
		this.customerNum = customerNum;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getGcode() {
		return gcode;
	}
	public void setGcode(String gcode) {
		this.gcode = gcode;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getZhiwu() {
		return zhiwu;
	}
	public void setZhiwu(String zhiwu) {
		this.zhiwu = zhiwu;
	}
	public Date getRuzhidate() {
		return ruzhidate;
	}
	public void setRuzhidate(Date ruzhidate) {
		this.ruzhidate = ruzhidate;
	}
	public String getTuijianren() {
		return tuijianren;
	}
	public void setTuijianren(String tuijianren) {
		this.tuijianren = tuijianren;
	}
	public String getAdr() {
		return adr;
	}
	public void setAdr(String adr) {
		this.adr = adr;
	}
	public Integer getBrdType() {
		return brdType;
	}
	public void setBrdType(Integer brdType) {
		this.brdType = brdType;
	}
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	public Date getModifydatetime() {
		return modifydatetime;
	}
	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getRealname() {
		return realname;
	}
	public void setRealname(String realname) {
		this.realname = realname;
	}
	public Date getBrd() {
		return brd;
	}
	public void setBrd(Date brd) {
		this.brd = brd;
	}
	public Date getCreatedatetimeStart() {
		return createdatetimeStart;
	}
	public void setCreatedatetimeStart(Date createdatetimeStart) {
		this.createdatetimeStart = createdatetimeStart;
	}
	public Date getCreatedatetimeEnd() {
		return createdatetimeEnd;
	}
	public void setCreatedatetimeEnd(Date createdatetimeEnd) {
		this.createdatetimeEnd = createdatetimeEnd;
	}
	public Date getModifydatetimeStart() {
		return modifydatetimeStart;
	}
	public void setModifydatetimeStart(Date modifydatetimeStart) {
		this.modifydatetimeStart = modifydatetimeStart;
	}
	public Date getModifydatetimeEnd() {
		return modifydatetimeEnd;
	}
	public void setModifydatetimeEnd(Date modifydatetimeEnd) {
		this.modifydatetimeEnd = modifydatetimeEnd;
	}
	public String getRoleIds() {
		return roleIds;
	}
	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}
	public String getRoleNames() {
		return roleNames;
	}
	public void setRoleNames(String roleNames) {
		this.roleNames = roleNames;
	}
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getOrganizationName() {
		return organizationName;
	}
	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getBz() {
		return bz;
	}
	public void setBz(String bz) {
		this.bz = bz;
	}
	public String getSolaryTypeId() {
		return solaryTypeId;
	}
	public void setSolaryTypeId(String solaryTypeId) {
		this.solaryTypeId = solaryTypeId;
	}
	
}
