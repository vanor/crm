package com.crm.app.entity;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "answerstage1")
public class AnswerStage1 {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
    private Long id;
	 
	@Column(name = "value", nullable = false, columnDefinition = "TEXT")
	private String value;
	 
	@ManyToOne
	@JoinColumn(name = "questionid", referencedColumnName = "id")
	@JsonManagedReference
	private QuestionStage1 questionstage1;
	 
	@ManyToOne
    @JoinColumn(name = "companyid", referencedColumnName = "id")
	@JsonManagedReference
    private Company company;
	
	@ManyToOne
    @JoinColumn(name = "editor_user_id", referencedColumnName = "id")
	@JsonManagedReference
    private Utilisateur editorUser;
	 
	@Column(name = "createdat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(name = "updatedat", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

    @Column(name = "deletedat", nullable = true)
    private Date deletedAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public QuestionStage1 getQuestionstage1() {
		return questionstage1;
	}

	public void setQuestionstage1(QuestionStage1 questionstage1) {
		this.questionstage1 = questionstage1;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	public Utilisateur getEditorUser() {
		return editorUser;
	}

	public void setEditorUser(Utilisateur editorUser) {
		this.editorUser = editorUser;
	}

	@Override
	public String toString() {
		return "AnswerStage1 [id=" + id + ", value=" + value + ", editorUser=" + editorUser + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
}
