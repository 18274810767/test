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

//日报

@Entity
@Table(name = "cdzongjie", catalog = "fydb")
public class Cdzongjie {
	private String id;
	private String name;
	private String finished;
	private Clob zongjie;
	private String notes;
	
	
	private Date createdatetime;
	private Date modifydatetime;
	
	public Cdzongjie(){
		
	}
	
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
	
	@Column(name = "NOTES", length = 200)
	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
	

}
