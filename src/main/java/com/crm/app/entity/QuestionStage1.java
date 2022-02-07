package com.crm.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "questionstage1")
public class QuestionStage1 {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
    private Long id;
	
	@Column(name = "value", nullable = false, columnDefinition = "TEXT")
	private String value;
	
	@Column(name = "type", nullable = false)
	private String type;	//the input type of the response. Can be text, date, boolean or file
	
	@Column(name = "choice_set", columnDefinition = "TEXT")
    private String choiceSet;
	
	@Column(name = "rating")
    private Integer rank;
	
	@Column(name = "priority_sector_number")
    private Integer prioritySectorNumber; // 1 for sector one, 2 for sector two and 3 for sector three.

    @OneToMany(mappedBy = "questionstage1", fetch = FetchType.EAGER)
    @JsonBackReference
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public String getChoiceSet() {
		return choiceSet;
	}

	public void setChoiceSet(String choiceSet) {
		this.choiceSet = choiceSet;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer order) {
		this.rank = order;
	}

	public Integer getPrioritySectorNumber() {
		return prioritySectorNumber;
	}

	public void setPrioritySectorNumber(Integer prioritySectorNumber) {
		this.prioritySectorNumber = prioritySectorNumber;
	}

	@Override
	public String toString() {
		return "QuestionStage1 [id=" + id + ", value=" + value + ", type=" + type + ", choiceSet=" + choiceSet
				+ ", rank=" + rank + ", prioritySectorNumber=" + prioritySectorNumber + ", answer=" + answer
				+ ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", deletedAt=" + deletedAt + "]";
	}
	
	public List<String> getAllChoices() {
		List<String> list = new ArrayList<>();
		if(this.choiceSet != null && !this.choiceSet.isEmpty()) {
			String[] choices = this.choiceSet.split("/");
			for(int i=0; i<choices.length; i++)
				list.add(choices[i]);
		}
		
		return list;
	}
	
	public AnswerStage1 getAnswerStage1ByCompanyId(Long id) {
		for(AnswerStage1 answerStage1 : this.answer) {
			Company company = answerStage1.getCompany();
			if(company != null && company.getId() == id)
				return answerStage1;
		}
		
		return null;
	}
}
