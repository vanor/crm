package com.crm.app.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "questionstage2")
public class QuestionStage2 {
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	 @Column(name = "value", nullable = false, columnDefinition = "TEXT")
	    private String value;

	    @OneToMany(mappedBy = "questionstage2", fetch = FetchType.EAGER)
	    @JsonManagedReference
	    private Set<AnswerStage2> answer;
	    
	    @ManyToOne
	    @JoinColumn(name = "secteurid", referencedColumnName = "id")
	    @JsonBackReference
	    private Secteur secteur;
	 
	    @Transient
	    private Long secteurid;

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

		public Set<AnswerStage2> getAnswer() {
			return answer;
		}

		public void setAnswer(Set<AnswerStage2> answer) {
			this.answer = answer;
		}

		public Secteur getSecteur() {
			return secteur;
		}

		public void setSecteur(Secteur secteur) {
			this.secteur = secteur;
		}

		public Long getSecteurid() {
			return secteurid;
		}

		public void setSecteurid(Long secteurid) {
			this.secteurid = secteurid;
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
			return "QuestionStage2 [id=" + id + ", value=" + value + ", answer=" + answer + ", secteur=" + secteur
					+ ", secteurid=" + secteurid + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
					+ ", deletedAt=" + deletedAt + "]";
		}
	    
	    
}
