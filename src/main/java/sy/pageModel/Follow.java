package sy.pageModel;

import java.io.Serializable;
import java.util.Date;

import sy.annt.Ext;
import sy.enums.ExtType;


public class Follow implements Serializable {

	private String id;
	@Ext(index = 1, group = { 1 }, label = "跟进方式", json = "json:[{\"text\":\"短信\",\"value\":\"1\"},{\"text\":\"电话\",\"value\":\"2\"},{\"text\":\"上门拜访\",\"value\":\"3\"},{\"text\":\"微信\",\"value\":\"4\"}]", type = ExtType.selectfield)
	private String type;
	@Ext(index = 4, group = { 1 }, label = "备注", type = ExtType.textareafield)
	private String remark;
	@Ext(index = 6, group = { 1 }, label = "附件", type = ExtType.textfield)
	private String note;
	@Ext(index = 1, group = { 2 }, label = "跟进时间", type = ExtType.textfield)
	private Date createDatetime;
	@Ext(index = 5, group = { 1 }, label = "销售机会", json = "", type = ExtType.checkboxfield)
	private String isjihui;
	@Ext(index = 2, group = { 1 }, label = "过程描述", json = "", type = ExtType.textareafield)
	private String gcDescr;
	@Ext(index = 3, group = { 1 }, label = "结果描述", json = "", type = ExtType.textareafield)
	private String jgDescr;
	
	private String userId;
	private String isQiangdan;
	
	private String customerId;
	private String customerName;
	
	
	public String getGcDescr() {
		return gcDescr;
	}
	public void setGcDescr(String gcDescr) {
		this.gcDescr = gcDescr;
	}
	public String getJgDescr() {
		return jgDescr;
	}
	public void setJgDescr(String jgDescr) {
		this.jgDescr = jgDescr;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getIsQiangdan() {
		return isQiangdan;
	}
	public void setIsQiangdan(String isQiangdan) {
		this.isQiangdan = isQiangdan;
	}
	public String getIsjihui() {
		return isjihui;
	}
	public void setIsjihui(String isjihui) {
		this.isjihui = isjihui;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getCreateDatetime() {
		return createDatetime;
	}
	public void setCreateDatetime(Date createDatetime) {
		this.createDatetime = createDatetime;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
