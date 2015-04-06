package sy.pageModel;

import java.util.Date;
import java.util.List;

import sy.annt.Ext;
import sy.enums.ExtAreaType;
import sy.enums.ExtType;

public class Customer implements java.io.Serializable {
	@Ext(index = 1, group = { 1 }, label = "", type = ExtType.hiddenfield)
	private String id;
	
	
	//*******************刘新建*******************************************************
	@Ext(index = 1, group = { 1 }, label = "来源", json = "json:[{\"value\":1,\"text\":\"电话筛选\"},{\"value\":2,\"text\":\"400电话咨询\"},{\"value\":3,\"text\":\"座机咨询\"},{\"value\":4,\"text\":\"手机咨询\"},{\"value\":5,\"text\":\"talk99咨询\"},{\"value\":6,\"text\":\"QQ咨询\"},{\"value\":7,\"text\":\"微信咨询\"},{\"value\":8,\"text\":\"后台留言\"},{\"value\":9,\"text\":\"短信群发\"},{\"value\":10,\"text\":\"合作机构\"},{\"value\":11,\"text\":\"转介绍\"},{\"value\":12,\"text\":\"其他\"}]", type = ExtType.selectfield)
	private int resources;
	@Ext(index = 1, group = { 1 }, label = "保护类型", json = "json:[{\"value\":1,\"text\":\"绝对保护\"},{\"value\":2,\"text\":\"相对保护\"},{\"value\":3,\"text\":\"公池\"}]", type = ExtType.selectfield)
	private Integer btype;
	@Ext(index = 1, group = { 2 }, label = "公司名称", type = ExtType.textfield)
	private String ltdName;
	@Ext(index = 1, group = { 2 }, label = "职务", type = ExtType.textfield)
	private String ltdZhiwu;
	@Ext(index = 1, group = { 2 }, label = "联系方式2", type = ExtType.textfield)
	private String phone2;
	@Ext(index = 1, group = { 2 }, label = "邮政编码", type = ExtType.textfield)
	private String areaCode;
	@Ext(index = 1, group = { 2 }, label = "公司地址", type = ExtType.textfield)
	private String ltdAdr;
	@Ext(index = 1, group = { 2 }, label = "部门", type = ExtType.textfield)
	private String ltdDet;
	@Ext(index = 1, group = { 2 }, label = "业务", type = ExtType.textfield)
	private String ltdYewu;
	@Ext(index = 1, group = { 2 }, label = "公司微信", type = ExtType.textfield)
	private String ltdWx;
	@Ext(index = 1, group = { 2 }, label = "产品", type = ExtType.textareafield)
	private String ltdChanpin;
	@Ext(index = 1, group = { 2 }, label = "公司备注", type = ExtType.textareafield)
	private String ltdNote;
	@Ext(index = 1, group = { 2 }, label = "种类",json="json:[{\"value\":1,\"text\":\"总裁未听\"},{\"value\":2,\"text\":\"总裁已听\"},{\"value\":3,\"text\":\"总裁已报\"},{\"value\":4,\"text\":\"总裁已上\"},{\"value\":5,\"text\":\"职场未听\"},{\"value\":6,\"text\":\"职场已听\"},{\"value\":7,\"text\":\"职场已报\"},{\"value\":8,\"text\":\"职场已上\"}]", type = ExtType.checkboxgroup)
	private String typeLabel;
	@Ext(index = 1, group = { 2 }, label = "标签",json="json:[{\"value\":1,\"text\":\"已电话沟通\"},{\"value\":2,\"text\":\"已拜访送票\"},{\"value\":3,\"text\":\"已报出价格\"},{\"value\":4,\"text\":\"已听体验课\"},{\"value\":5,\"text\":\"已成交-定金\"},{\"value\":6,\"text\":\"已成交-全款\"}]\r\n", type = ExtType.checkboxgroup)
	private String kLabel;
	
	@Ext(index = 8, group = { 1 }, label = "生日类型", json="json:[{\"value\":1,\"text\":'农历'},{\"value\":2,\"text\":'阳历'}]",type = ExtType.selectfield)
	private Integer brdtype;
	@Ext(index = 1, group = { 2 }, label = "生日", type = ExtType.datepickerfield)
	private Date brd;
	
	
	//**************************************************************************
	
	@Ext(index = 1, group = { 2 }, label = "授权书", json = "json:[{\"value\":1,\"text\":'签订'},{\"value\":2,\"text\":'未签订'}]", type = ExtType.selectfield)
	private String BSqs;
	@Ext(index = 1, group = { 2 }, label = "价值等级", json = "json:[{\"value\":1,\"text\":'高'},{\"value\":2,\"text\":'中'},{\"value\":3,\"text\":'一般'}]", type = ExtType.selectfield)
	private String CJiazhi;
	@Ext(index = 1, group = { 2 }, label = "简称", type = ExtType.textfield)
	private String CName;
	@Ext(index = 7, group = { 1 }, label = "身份证", type = ExtType.textfield)
	private String LCardCode;
	@Ext(index = 6, group = { 1 }, label = "证件类型", json = "json:[{\"value\":1,\"text\":'身份证'},{\"value\":2,\"text\":'士官证'},{\"value\":3,\"text\":'户口本'}]", type = ExtType.selectfield)
	private String LCardType;
	@Ext(index = 1, group = { 2 }, label = "传真", type = ExtType.textfield)
	private String LFax;
	@Ext(index = 1, group = { 9 }, label = "国家", type = ExtType.textfield)
	private String LGuojia;
	@Ext(index = 1, group = { 2 }, label = "省", type = ExtType.selectfield,area=ExtAreaType.sheng)
	private String LSheng;
	@Ext(index = 1, group = { 2 }, label = "市", type = ExtType.selectfield,area=ExtAreaType.shi)
	private String LShi;
	@Ext(index = 1, group = { 2 }, label = "网址", type = ExtType.urlfield)
	private String LWww;
	@Ext(index = 1, group = { 2 }, label = "县", type = ExtType.selectfield,area=ExtAreaType.shi)
	private String LXian;
	@Ext(index = 1, group = { 2 }, label = "邮编", type = ExtType.textfield)
	private String LYoubian;
	@Ext(index = 8, group = { 1 }, label = "住址", type = ExtType.textfield)
	private String adr;
	
	private Date createdatetime;
	
	@Ext(index = 9, group = { 1 }, label = "邮件", type = ExtType.emailfield)
	private String email;
	@Ext(index = 1, group = { 2 }, label = "规模", json = "json:[{\"value\":1,\"text\":'50人以下'},{\"value\":2,\"text\":'50-100人'},{\"value\":3,\"text\":'100-500人'},{\"value\":4,\"text\":'500人以上'}]", type = ExtType.selectfield)
	private String guimo;
	
	@Ext(index = 1, group = { 2 }, label = "行业", type = ExtType.textfield)
	private String hangye;
	
	@Ext(index = 1, group = { 2 }, label = "重点客户", json = "json:[{\"value\":1,\"text\":'是'},{\"value\":2,\"text\":'否'}]", type = ExtType.selectfield)
	private String isTop;
	@Ext(index = 1, group = { 2 }, label = "来源", json = "json:[{\"value\":1,\"text\":'转介绍'},{\"value\":2,\"text\":'拜访'},{\"value\":2,\"text\":'互联网'}]", type = ExtType.selectfield)
	private String laiyuan;
	
	private Date modifydatetime;
	@Ext(index = 3, group = { 1 }, label = "姓名", type = ExtType.textfield,place="用户姓名")
	private String name;
	@Ext(index = 2, group = { 1 }, label = "手机", type = ExtType.textfield)
	private String phone;
	@Ext(index = 4, group = { 1 }, label = "qq", type = ExtType.textfield)
	private String qq;
	@Ext(index = 10, group = { 1 }, label = "备注", type = ExtType.textareafield)
	private String topComent;
	private String topFenlei;
	@Ext(index = 1, group = { 1 }, label = "等级", json = "json:[{\"value\":1,\"text\":'A'},{\"value\":2,\"text\":'AA'},{\"value\":3,\"text\":'AAA'},{\"value\":4,\"text\":'AAAA'},{\"value\":5,\"text\":'AAAAA'}]", type = ExtType.selectfield)
	private String topLevel;
	@Ext(index = 1, group = { 9 }, label = "旺旺", type = ExtType.textfield)
	private String ww;
	@Ext(index = 5, group = { 1 }, label = "微信", type = ExtType.textfield)
	private String wx;
	@Ext(index = 1, group = { 9 }, label = "信用等级", type = ExtType.textfield)
	private String xleve;
	
	private String zhonglei;
	
	@Ext(index = 1, group = { 1 }, label = "类型", json = "json:[{\"value\":1,\"text\":'个人'},{\"value\":2,\"text\":'公司'}]", type = ExtType.selectfield)
	private String type;
	
	@Ext(index = 1, group = { 9 }, label = "关系人", type = ExtType.textfield)
	private String guanxi;
	@Ext(index = 1, group = { 9 }, label = "阶段", type = ExtType.textfield)
	private String jieduan;
	@Ext(index = 1, group = { 9 }, label = "上级推荐人", type = ExtType.textfield)
	private String shangji;
	@Ext(index = 1, group = { 9 }, label = "简介", type = ExtType.textfield)
	private String jianjie;
	@Ext(index = 1, group = { 9 }, label = "是否购买", type = ExtType.textfield)
	private String isGoumai;
	private String label;
	
	private Integer balance;//余额
	
	private String userId;
	private String userName;
	private Date createdatetimeStart;
	private Date createdatetimeEnd;
	private Date modifydatetimeStart;
	private Date modifydatetimeEnd;
	private String courseIds;
	@Ext(index = 1, group = { 9 },json="hsql:{\"sql\":\"from Tcourses t\",\"value\":\"name\",\"text\":\"id\"}", label = "是否购买", type = ExtType.textfield)
	private String courseNames;//课程
	private String pstatus;
	private String queryMode;
	
	public String getQueryMode() {
		return queryMode;
	}

	public void setQueryMode(String queryMode) {
		this.queryMode = queryMode;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	
	

	public Integer getBrdtype() {
		return brdtype;
	}

	public void setBrdtype(Integer brdtype) {
		this.brdtype = brdtype;
	}

	public Date getBrd() {
		return brd;
	}

	public void setBrd(Date brd) {
		this.brd = brd;
	}

	public int getResources() {
		return resources;
	}

	public void setResources(int resources) {
		this.resources = resources;
	}

	public Integer getBtype() {
		return btype;
	}

	public void setBtype(Integer btype) {
		this.btype = btype;
	}

	public String getLtdName() {
		return ltdName;
	}

	public void setLtdName(String ltdName) {
		this.ltdName = ltdName;
	}

	public String getLtdZhiwu() {
		return ltdZhiwu;
	}

	public void setLtdZhiwu(String ltdZhiwu) {
		this.ltdZhiwu = ltdZhiwu;
	}

	public String getPhone2() {
		return phone2;
	}

	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getLtdAdr() {
		return ltdAdr;
	}

	public void setLtdAdr(String ltdAdr) {
		this.ltdAdr = ltdAdr;
	}

	public String getLtdDet() {
		return ltdDet;
	}

	public void setLtdDet(String ltdDet) {
		this.ltdDet = ltdDet;
	}

	public String getLtdYewu() {
		return ltdYewu;
	}

	public void setLtdYewu(String ltdYewu) {
		this.ltdYewu = ltdYewu;
	}

	public String getLtdWx() {
		return ltdWx;
	}

	public void setLtdWx(String ltdWx) {
		this.ltdWx = ltdWx;
	}

	public String getLtdChanpin() {
		return ltdChanpin;
	}

	public void setLtdChanpin(String ltdChanpin) {
		this.ltdChanpin = ltdChanpin;
	}

	public String getLtdNote() {
		return ltdNote;
	}

	public void setLtdNote(String ltdNote) {
		this.ltdNote = ltdNote;
	}

	public String getTypeLabel() {
		return typeLabel;
	}

	public void setTypeLabel(String typeLabel) {
		this.typeLabel = typeLabel;
	}

	public String getkLabel() {
		return kLabel;
	}

	public void setkLabel(String kLabel) {
		this.kLabel = kLabel;
	}

	public String getCourseIds() {
		return courseIds;
	}

	public void setCourseIds(String courseIds) {
		this.courseIds = courseIds;
	}

	public String getCourseNames() {
		return courseNames;
	}

	public void setCourseNames(String courseNames) {
		this.courseNames = courseNames;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBSqs() {
		return BSqs;
	}

	public void setBSqs(String bSqs) {
		BSqs = bSqs;
	}

	public String getCJiazhi() {
		return CJiazhi;
	}

	public void setCJiazhi(String cJiazhi) {
		CJiazhi = cJiazhi;
	}

	public String getCName() {
		return CName;
	}

	public void setCName(String cName) {
		CName = cName;
	}

	public String getLCardCode() {
		return LCardCode;
	}

	public void setLCardCode(String lCardCode) {
		LCardCode = lCardCode;
	}

	public String getLCardType() {
		return LCardType;
	}

	public void setLCardType(String lCardType) {
		LCardType = lCardType;
	}

	public String getLFax() {
		return LFax;
	}

	public void setLFax(String lFax) {
		LFax = lFax;
	}

	public String getLGuojia() {
		return LGuojia;
	}

	public void setLGuojia(String lGuojia) {
		LGuojia = lGuojia;
	}

	public String getLSheng() {
		return LSheng;
	}

	public void setLSheng(String lSheng) {
		LSheng = lSheng;
	}

	public String getLShi() {
		return LShi;
	}

	public void setLShi(String lShi) {
		LShi = lShi;
	}

	public String getLWww() {
		return LWww;
	}

	public void setLWww(String lWww) {
		LWww = lWww;
	}

	public String getLXian() {
		return LXian;
	}

	public void setLXian(String lXian) {
		LXian = lXian;
	}

	public String getLYoubian() {
		return LYoubian;
	}

	public void setLYoubian(String lYoubian) {
		LYoubian = lYoubian;
	}

	public String getAdr() {
		return adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	public Date getCreatedatetime() {
		return createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGuimo() {
		return guimo;
	}

	public void setGuimo(String guimo) {
		this.guimo = guimo;
	}

	public String getHangye() {
		return hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	public String getIsTop() {
		return isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	public String getLaiyuan() {
		return laiyuan;
	}

	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getTopComent() {
		return topComent;
	}

	public void setTopComent(String topComent) {
		this.topComent = topComent;
	}

	public String getTopFenlei() {
		return topFenlei;
	}

	public void setTopFenlei(String topFenlei) {
		this.topFenlei = topFenlei;
	}

	public String getTopLevel() {
		return topLevel;
	}

	public void setTopLevel(String topLevel) {
		this.topLevel = topLevel;
	}

	public String getWw() {
		return ww;
	}

	public void setWw(String ww) {
		this.ww = ww;
	}

	public String getWx() {
		return wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	public String getXleve() {
		return xleve;
	}

	public void setXleve(String xleve) {
		this.xleve = xleve;
	}

	public String getZhonglei() {
		return zhonglei;
	}

	public void setZhonglei(String zhonglei) {
		this.zhonglei = zhonglei;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getGuanxi() {
		return guanxi;
	}

	public void setGuanxi(String guanxi) {
		this.guanxi = guanxi;
	}

	public String getJieduan() {
		return jieduan;
	}

	public void setJieduan(String jieduan) {
		this.jieduan = jieduan;
	}

	public String getShangji() {
		return shangji;
	}

	public void setShangji(String shangji) {
		this.shangji = shangji;
	}

	public String getJianjie() {
		return jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	public String getIsGoumai() {
		return isGoumai;
	}

	public void setIsGoumai(String isGoumai) {
		this.isGoumai = isGoumai;
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

}
