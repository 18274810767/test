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

/**
 * Tcustomer entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tcustomer", catalog = "fydb")
public class Tcustomer implements java.io.Serializable {

	// Fields

	private String id;
	private Tuser tuser;
	private String BSqs;
	private String CJiazhi;
	private String CName;
	private String LCardCode;
	private String LCardType;
	private String LFax;
	private String LGuojia;
	private String LSheng;
	private String LShi;
	private String LWww;
	private String LXian;
	private String LYoubian;
	private String adr;
	private Integer balance;
	private Date createdatetime;
	private String email;
	private String guanxi;
	private String guimo;
	private String hangye;
	private String isGoumai;
	private String isTop;
	private String jianjie;
	private String jieduan;
	private String label;
	private String laiyuan;
	private Date modifydatetime;
	private String name;
	private String phone;
	private String qq;
	private String shangji;
	private String topComent;
	private String topFenlei;
	private String topLevel;
	private String type;
	private String ww;
	private String wx;
	private String xleve;
	private String zhonglei;
	private Date brd;
	private Integer brdtype;
	private Integer btype;
	private Set<Tfollow> tfollows = new HashSet<Tfollow>(0);
	private Set<Tcourses> tcourseses = new HashSet<Tcourses>(0);
	private Set<Tjinianri> tjinianris = new HashSet<Tjinianri>(0);

	// Constructors

	/** default constructor */
	public Tcustomer() {
	}

	/** minimal constructor */
	public Tcustomer(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tcustomer(String id, Tuser tuser, String BSqs, String CJiazhi,
			String CName, String LCardCode, String LCardType, String LFax,
			String LGuojia, String LSheng, String LShi, String LWww,
			String LXian, String LYoubian, String adr, Integer balance,
			Date createdatetime, String email, String guanxi, String guimo,
			String hangye, String isGoumai, String isTop, String jianjie,
			String jieduan, String label, String laiyuan, Date modifydatetime,
			String name, String phone, String qq, String shangji,
			String topComent, String topFenlei, String topLevel, String type,
			String ww, String wx, String xleve, String zhonglei, Date brd,
			Integer brdtype, Integer btype, Set<Tfollow> tfollows,
			Set<Tcourses> tcourseses, Set<Tjinianri> tjinianris) {
		this.id = id;
		this.tuser = tuser;
		this.BSqs = BSqs;
		this.CJiazhi = CJiazhi;
		this.CName = CName;
		this.LCardCode = LCardCode;
		this.LCardType = LCardType;
		this.LFax = LFax;
		this.LGuojia = LGuojia;
		this.LSheng = LSheng;
		this.LShi = LShi;
		this.LWww = LWww;
		this.LXian = LXian;
		this.LYoubian = LYoubian;
		this.adr = adr;
		this.balance = balance;
		this.createdatetime = createdatetime;
		this.email = email;
		this.guanxi = guanxi;
		this.guimo = guimo;
		this.hangye = hangye;
		this.isGoumai = isGoumai;
		this.isTop = isTop;
		this.jianjie = jianjie;
		this.jieduan = jieduan;
		this.label = label;
		this.laiyuan = laiyuan;
		this.modifydatetime = modifydatetime;
		this.name = name;
		this.phone = phone;
		this.qq = qq;
		this.shangji = shangji;
		this.topComent = topComent;
		this.topFenlei = topFenlei;
		this.topLevel = topLevel;
		this.type = type;
		this.ww = ww;
		this.wx = wx;
		this.xleve = xleve;
		this.zhonglei = zhonglei;
		this.brd = brd;
		this.brdtype = brdtype;
		this.btype = btype;
		this.tfollows = tfollows;
		this.tcourseses = tcourseses;
		this.tjinianris = tjinianris;
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
	@JoinColumn(name = "USER_ID")
	public Tuser getTuser() {
		return this.tuser;
	}

	public void setTuser(Tuser tuser) {
		this.tuser = tuser;
	}

	@Column(name = "B_SQS", length = 36)
	public String getBSqs() {
		return this.BSqs;
	}

	public void setBSqs(String BSqs) {
		this.BSqs = BSqs;
	}

	@Column(name = "C_JIAZHI", length = 36)
	public String getCJiazhi() {
		return this.CJiazhi;
	}

	public void setCJiazhi(String CJiazhi) {
		this.CJiazhi = CJiazhi;
	}

	@Column(name = "C_NAME", length = 50)
	public String getCName() {
		return this.CName;
	}

	public void setCName(String CName) {
		this.CName = CName;
	}

	@Column(name = "L_CARD_CODE", length = 100)
	public String getLCardCode() {
		return this.LCardCode;
	}

	public void setLCardCode(String LCardCode) {
		this.LCardCode = LCardCode;
	}

	@Column(name = "L_CARD_TYPE", length = 36)
	public String getLCardType() {
		return this.LCardType;
	}

	public void setLCardType(String LCardType) {
		this.LCardType = LCardType;
	}

	@Column(name = "L_FAX", length = 50)
	public String getLFax() {
		return this.LFax;
	}

	public void setLFax(String LFax) {
		this.LFax = LFax;
	}

	@Column(name = "L_GUOJIA", length = 50)
	public String getLGuojia() {
		return this.LGuojia;
	}

	public void setLGuojia(String LGuojia) {
		this.LGuojia = LGuojia;
	}

	@Column(name = "L_SHENG", length = 50)
	public String getLSheng() {
		return this.LSheng;
	}

	public void setLSheng(String LSheng) {
		this.LSheng = LSheng;
	}

	@Column(name = "L_SHI", length = 50)
	public String getLShi() {
		return this.LShi;
	}

	public void setLShi(String LShi) {
		this.LShi = LShi;
	}

	@Column(name = "L_WWW", length = 100)
	public String getLWww() {
		return this.LWww;
	}

	public void setLWww(String LWww) {
		this.LWww = LWww;
	}

	@Column(name = "L_XIAN", length = 50)
	public String getLXian() {
		return this.LXian;
	}

	public void setLXian(String LXian) {
		this.LXian = LXian;
	}

	@Column(name = "L_YOUBIAN", length = 50)
	public String getLYoubian() {
		return this.LYoubian;
	}

	public void setLYoubian(String LYoubian) {
		this.LYoubian = LYoubian;
	}

	@Column(name = "adr", length = 100)
	public String getAdr() {
		return this.adr;
	}

	public void setAdr(String adr) {
		this.adr = adr;
	}

	@Column(name = "balance")
	public Integer getBalance() {
		return this.balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "createdatetime", length = 10)
	public Date getCreatedatetime() {
		return this.createdatetime;
	}

	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}

	@Column(name = "email", length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "GUANXI")
	public String getGuanxi() {
		return this.guanxi;
	}

	public void setGuanxi(String guanxi) {
		this.guanxi = guanxi;
	}

	@Column(name = "GUIMO", length = 36)
	public String getGuimo() {
		return this.guimo;
	}

	public void setGuimo(String guimo) {
		this.guimo = guimo;
	}

	@Column(name = "hangye", length = 50)
	public String getHangye() {
		return this.hangye;
	}

	public void setHangye(String hangye) {
		this.hangye = hangye;
	}

	@Column(name = "IS_GOUMAI", length = 36)
	public String getIsGoumai() {
		return this.isGoumai;
	}

	public void setIsGoumai(String isGoumai) {
		this.isGoumai = isGoumai;
	}

	@Column(name = "is_top", length = 1)
	public String getIsTop() {
		return this.isTop;
	}

	public void setIsTop(String isTop) {
		this.isTop = isTop;
	}

	@Column(name = "JIANJIE", length = 50)
	public String getJianjie() {
		return this.jianjie;
	}

	public void setJianjie(String jianjie) {
		this.jianjie = jianjie;
	}

	@Column(name = "JIEDUAN", length = 36)
	public String getJieduan() {
		return this.jieduan;
	}

	public void setJieduan(String jieduan) {
		this.jieduan = jieduan;
	}

	@Column(name = "label", length = 36)
	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Column(name = "LAIYUAN", length = 36)
	public String getLaiyuan() {
		return this.laiyuan;
	}

	public void setLaiyuan(String laiyuan) {
		this.laiyuan = laiyuan;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "modifydatetime", length = 10)
	public Date getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

	@Column(name = "name", length = 100)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "phone", length = 50)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "qq", length = 50)
	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "SHANGJI", length = 36)
	public String getShangji() {
		return this.shangji;
	}

	public void setShangji(String shangji) {
		this.shangji = shangji;
	}

	@Column(name = "TOP_COMENT")
	public String getTopComent() {
		return this.topComent;
	}

	public void setTopComent(String topComent) {
		this.topComent = topComent;
	}

	@Column(name = "TOP_FENLEI", length = 50)
	public String getTopFenlei() {
		return this.topFenlei;
	}

	public void setTopFenlei(String topFenlei) {
		this.topFenlei = topFenlei;
	}

	@Column(name = "topLevel", length = 36)
	public String getTopLevel() {
		return this.topLevel;
	}

	public void setTopLevel(String topLevel) {
		this.topLevel = topLevel;
	}

	@Column(name = "TYPE", length = 36)
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "ww", length = 50)
	public String getWw() {
		return this.ww;
	}

	public void setWw(String ww) {
		this.ww = ww;
	}

	@Column(name = "wx", length = 50)
	public String getWx() {
		return this.wx;
	}

	public void setWx(String wx) {
		this.wx = wx;
	}

	@Column(name = "XLEVE", length = 36)
	public String getXleve() {
		return this.xleve;
	}

	public void setXleve(String xleve) {
		this.xleve = xleve;
	}

	@Column(name = "ZHONGLEI", length = 36)
	public String getZhonglei() {
		return this.zhonglei;
	}

	public void setZhonglei(String zhonglei) {
		this.zhonglei = zhonglei;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "brd", length = 10)
	public Date getBrd() {
		return this.brd;
	}

	public void setBrd(Date brd) {
		this.brd = brd;
	}

	@Column(name = "brdtype")
	public Integer getBrdtype() {
		return this.brdtype;
	}

	public void setBrdtype(Integer brdtype) {
		this.brdtype = brdtype;
	}

	@Column(name = "btype")
	public Integer getBtype() {
		return this.btype;
	}

	public void setBtype(Integer btype) {
		this.btype = btype;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcustomer")
	public Set<Tfollow> getTfollows() {
		return this.tfollows;
	}

	public void setTfollows(Set<Tfollow> tfollows) {
		this.tfollows = tfollows;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "tcustomer_tcourse", catalog = "fydb", joinColumns = { @JoinColumn(name = "customer_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "course_id", nullable = false, updatable = false) })
	public Set<Tcourses> getTcourseses() {
		return this.tcourseses;
	}

	public void setTcourseses(Set<Tcourses> tcourseses) {
		this.tcourseses = tcourseses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcustomer")
	public Set<Tjinianri> getTjinianris() {
		return this.tjinianris;
	}

	public void setTjinianris(Set<Tjinianri> tjinianris) {
		this.tjinianris = tjinianris;
	}

}