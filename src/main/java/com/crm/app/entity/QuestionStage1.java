package com.crm.app.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "questionstage1")
public class QuestionStage1 implements Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	 @Column(name = "value", nullable = false, columnDefinition = "TEXT")
	    private String value;

	    @OneToMany(mappedBy = "questionstage1", fetch = FetchType.EAGER)
	    @JsonManagedReference
	    private Set<AnswerStage1> answer;

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

		public Set<AnswerStage1> getAnswer() {
			return answer;
		}

		public void setAnswer(Set<AnswerStage1> answer) {
			this.answer = answer;
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
			return "QuestionStage1 [id=" + id + ", value=" + value + ", answer=" + answer + ", createdAt=" + createdAt
					+ ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
		}
	    
	    

}
