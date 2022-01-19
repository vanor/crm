package com.crm.app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "answerstage2")
public class AnswerStage2 implements Serializable {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	 @Column(name = "value", nullable = false, columnDefinition = "TEXT")
	    private String value;
	 
	 @ManyToOne
	    @JoinColumn(name = "questionid", referencedColumnName = "id")
	    @JsonBackReference
	    private QuestionStage2 questionstage2;
	 
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

		public QuestionStage2 getQuestionstage2() {
			return questionstage2;
		}

		public void setQuestionstage2(QuestionStage2 questionstage2) {
			this.questionstage2 = questionstage2;
		}

		public Long getQuestionid() {
			return questionid;
		}

		public void setQuestionid(Long questionid) {
			this.questionid = questionid;
		}

		public Company getCompany() {
			return company;
		}

		public void setCompany(Company company) {
			this.company = company;
		}

		public Long getCompanyid() {
			return companyid;
		}

		public void setCompanyid(Long companyid) {
			this.companyid = companyid;
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

		@Override
		public String toString() {
			return "AnswerStage2 [id=" + id + ", value=" + value + ", questionstage2=" + questionstage2
					+ ", questionid=" + questionid + ", company=" + company + ", companyid=" + companyid
					+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
		}

	    
	    
}
