package sy.model;

import java.sql.Clob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
//周报
@Entity
@Table(name = "cwzongjie", catalog = "fydb")
public class Cwzongjie {
	private String id;
	private String name;//姓名
	private String finished;//工作内容
	private String jilu;//拜访客户记录
	private String hudong;//客户的互动
	private Clob zongjie;//周报总结
	
	private Date createdatetime;//创建时间
	private Date modifydatetime;//修改时间
	
	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name = "NAME", length = 200)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name = "FINISHED", length = 200)
	public String getFinished() {
		return finished;
	}
	public void setFinished(String finished) {
		this.finished = finished;
	}
	@Column(name = "JILU", length = 200)
	public String getJilu() {
		return jilu;
	}
	public void setJilu(String jilu) {
		this.jilu = jilu;
	}
	@Column(name = "HUDONG", length = 200)
	public String getHudong() {
		return hudong;
	}
	public void setHudong(String hudong) {
		this.hudong = hudong;
	}
	@Column(name = "ZONGJIE", length = 200)
	public Clob getZongjie() {
		return zongjie;
	}
	public void setZongjie(Clob zongjie) {
		this.zongjie = zongjie;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "CREATEDATETIME", length = 10)
	public Date getCreatedatetime() {
		return createdatetime;
	}
	public void setCreatedatetime(Date createdatetime) {
		this.createdatetime = createdatetime;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "MODIFYDATETIME", length = 10)
	public Date getModifydatetime() {
		return modifydatetime;
	}
	public void setModifydatetime(Date modifydatetime) {
		this.modifydatetime = modifydatetime;
	}
	

}
