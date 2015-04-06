package sy.pageModel;

import java.util.Date;

public class Courses implements java.io.Serializable{
	
	private String id;
	private String name;
	private Date createDateTime;
	private String note;
	private Integer num;
	private String problems;
	private Integer numGraduate;
	private String effect;
	private String point;
	private String isSign;
	private String isPay;
	private String isProvide;
	private Integer numSeat;
	private Integer maxNum;
	
	private Date createdatetimeStart;
	private Date createdatetimeEnd;
	private Date modifydatetimeStart;
	private Date modifydatetimeEnd;
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getCreateDateTime() {
		return createDateTime;
	}
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	public String getProblems() {
		return problems;
	}
	public void setProblems(String problems) {
		this.problems = problems;
	}
	public Integer getNumGraduate() {
		return numGraduate;
	}
	public void setNumGraduate(Integer numGraduate) {
		this.numGraduate = numGraduate;
	}
	public String getEffect() {
		return effect;
	}
	public void setEffect(String effect) {
		this.effect = effect;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getIsSign() {
		return isSign;
	}
	public void setIsSign(String isSign) {
		this.isSign = isSign;
	}
	public String getIsPay() {
		return isPay;
	}
	public void setIsPay(String isPay) {
		this.isPay = isPay;
	}
	public String getIsProvide() {
		return isProvide;
	}
	public void setIsProvide(String isProvide) {
		this.isProvide = isProvide;
	}
	public Integer getNumSeat() {
		return numSeat;
	}
	public void setNumSeat(Integer numSeat) {
		this.numSeat = numSeat;
	}
	public Integer getMaxNum() {
		return maxNum;
	}
	public void setMaxNum(Integer maxNum) {
		this.maxNum = maxNum;
	}
	
}
