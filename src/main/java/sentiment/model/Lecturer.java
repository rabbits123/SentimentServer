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
@Table(name = "lecturer")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Lecturer implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="Id")
	private int Id;
	
	public int getId() {
		return Id;
	}
	public Lecturer() {
	}

	public Lecturer(String lecturerName) {
		super();
		this.lecturerName = lecturerName;
	}

	public void setId(int id) {
		this.Id = id;
	}

	@Column(name="LecturerName")
	private String lecturerName;
	
	@Column(name="Gender")
	private String gender;
	
	@Column(name="DateOfBirth")
	private String dateOfBirth;

	public String getlecturerName() {
		return lecturerName;
	}

	public void setlecturerName(String lecturerName) {
		this.lecturerName = lecturerName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	
	
}
