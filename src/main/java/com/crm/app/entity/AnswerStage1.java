package com.crm.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "answerstage1")
public class AnswerStage1 implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO) 
	    private Long id;
	 
	 @Column(name = "value", nullable = false, columnDefinition = "TEXT")
	    private String value;
	 
	 @ManyToOne
	    @JoinColumn(name = "questionid", referencedColumnName = "id")
	    @JsonBackReference
	    private QuestionStage1 questionstage1;
	 
	 @Transient
	    private Long questionid;
	 
	 @ManyToOne
	    @JoinColumn(name = "companyid", referencedColumnName = "id")
	    @JsonBackReference
	    private Company company;
	 
	 @Transient
	    private Long companyid;

	 
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

		public QuestionStage1 getQuestion() {
			return questionstage1;
		}

		public void setQuestion(QuestionStage1 question) {
			this.questionstage1 = question;
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

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		@Override
		public String toString() {
			return "AnswerStage1 [id=" + id + ", value=" + value + ", question=" + questionstage1 + ", company=" + company
					+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
		}

	
	    

}
