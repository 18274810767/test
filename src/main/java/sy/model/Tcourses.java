package sy.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Tcourses entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tcourses", catalog = "fydb")
public class Tcourses implements java.io.Serializable {

	// Fields

	private String id;
	private Date createDateTime;
	private String effect;
	private String isPay;
	private String isProvide;
	private String isSign;
	private Integer maxNum;
	private Date modifydatetime;
	private String name;
	private String note;
	private Integer num;
	private Integer numGraduate;
	private Integer numSeat;
	private String point;
	private String problems;
	private Set<Tcustomer> tcustomers = new HashSet<Tcustomer>(0);

	// Constructors

	/** default constructor */
	public Tcourses() {
	}

	/** minimal constructor */
	public Tcourses(String id) {
		this.id = id;
	}

	/** full constructor */
	public Tcourses(String id, Date createDateTime, String effect,
			String isPay, String isProvide, String isSign, Integer maxNum,
			Date modifydatetime, String name, String note, Integer num,
			Integer numGraduate, Integer numSeat, String point,
			String problems, Set<Tcustomer> tcustomers) {
		this.id = id;
		this.createDateTime = createDateTime;
		this.effect = effect;
		this.isPay = isPay;
		this.isProvide = isProvide;
		this.isSign = isSign;
		this.maxNum = maxNum;
		this.modifydatetime = modifydatetime;
		this.name = name;
		this.note = note;
		this.num = num;
		this.numGraduate = numGraduate;
		this.numSeat = numSeat;
		this.point = point;
		this.problems = problems;
		this.tcustomers = tcustomers;
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

	@Temporal(TemporalType.DATE)
	@Column(name = "createDateTime", length = 10)
	public Date getCreateDateTime() {
		return this.createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	@Column(name = "effect")
	public String getEffect() {
		return this.effect;
	}

	public void setEffect(String effect) {
		this.effect = effect;
	}

	@Column(name = "is_pay", length = 1)
	public String getIsPay() {
		return this.isPay;
	}

	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}

	@Column(name = "is_provide", length = 1)
	public String getIsProvide() {
		return this.isProvide;
	}

	public void setIsProvide(String isProvide) {
		this.isProvide = isProvide;
	}

	@Column(name = "is_sign", length = 1)
	public String getIsSign() {
		return this.isSign;
	}

	public void setIsSign(String isSign) {
		this.isSign = isSign;
	}

	@Column(name = "max_num")
	public Integer getMaxNum() {
		return this.maxNum;
	}

	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATETIME", length = 10)
	public Date getModifydatetime() {
		return this.modifydatetime;
	}

	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}

	@Column(name = "name", length = 50)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "note", length = 500)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "num")
	public Integer getNum() {
		return this.num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	@Column(name = "num_graduate")
	public Integer getNumGraduate() {
		return this.numGraduate;
	}

	public void setNumGraduate(Integer numGraduate) {
		this.numGraduate = numGraduate;
	}

	@Column(name = "num_seat")
	public Integer getNumSeat() {
		return this.numSeat;
	}

	public void setNumSeat(Integer numSeat) {
		this.numSeat = numSeat;
	}

	@Column(name = "point", length = 100)
	public String getPoint() {
		return this.point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	@Column(name = "problems", length = 100)
	public String getProblems() {
		return this.problems;
	}

	public void setProblems(String problems) {
		this.problems = problems;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tcourseses")
	public Set<Tcustomer> getTcustomers() {
		return this.tcustomers;
	}

	public void setTcustomers(Set<Tcustomer> tcustomers) {
		this.tcustomers = tcustomers;
	}

}