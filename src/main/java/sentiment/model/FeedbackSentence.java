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
@Table(name = "feedbacksentence")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "createdAt", "updatedAt" }, allowGetters = true)
public class FeedbackSentence implements Serializable {
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name="Content")
	private String content;

	@Column(name="TopicLable")
	private Integer topiclabel;

	@Column(name="SentitmentLable")
	private Integer sentimentlabel;

	@Column(name="lecturerId")
	private Integer lecturerid;

	@Column(name="subjectId")
	private Integer subjectid;

	@Column(name="departmentId")
	private String departmentid;

	@Column(name="semeterId")
	private Integer semeterid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTopiclabel() {
		return topiclabel;
	}

	public void setTopiclabel(int topiclabel) {
		this.topiclabel = topiclabel;
	}

	public Integer getSentimentlabel() {
		return sentimentlabel;
	}

	public void setSentimentlabel(int sentimentlabel) {
		this.sentimentlabel = sentimentlabel;
	}

	public Integer getLecturerid() {
		return lecturerid;
	}

	public void setLecturerid(int lecturerid) {
		this.lecturerid = lecturerid;
	}

	public Integer getSubjectid() {
		return subjectid;
	}

	public void setSubjectid(int subjectid) {
		this.subjectid = subjectid;
	}

	public String getDepartmentid() {
		return departmentid;
	}

	public void setDepartmentid(String departmentid) {
		this.departmentid = departmentid;
	}

	public Integer getSemeterid() {
		return semeterid;
	}

	public void setSemeterid(int semeterid) {
		this.semeterid = semeterid;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
