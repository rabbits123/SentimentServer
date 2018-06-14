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
@Table(name = "semeter")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class Semeter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		this.Id = id;
	}

	@Column(name = "SemeterName")
	private String semeterName;

	public String getDepartmentName() {
		return semeterName;
	}

	public void setDepartmentName(String semeterName) {
		this.semeterName = semeterName;
	}

	public Semeter(String semeterName) {
		super();
		this.semeterName = semeterName;
	}

	public Semeter() {
	}

}
