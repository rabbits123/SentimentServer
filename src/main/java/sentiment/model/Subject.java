package sentiment.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "subject")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Subject implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int Id;
	
	public Subject(String subjectCode, String subjectName) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
	}
	
	public Subject() {
		
	}
	
	public int getId() {
		return Id;
	}

	public void setId(Integer id) {
		this.Id = id;
	}

	@Column(name="SubjectName")
	private String subjectName;

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
	@Column(name="SubjectCode")
	private String subjectCode;

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String SubjectCode) {
		this.subjectName = subjectCode;
	}
	
}
