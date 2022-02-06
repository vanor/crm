package com.crm.app.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "questionstage3")
public class QuestionStage3 {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
    private Long id;

	@Column(name = "value", nullable = false, columnDefinition = "TEXT")
    private String value;
	
	@Column(name = "type", nullable = false)
    private String type; //the input type of the response. Can be text, date, boolean or file
	
	@Column(name = "choice_set", columnDefinition = "TEXT")
    private String choiceSet;
	
	@Column(name = "rank")
    private Integer rank;

    @OneToMany(mappedBy = "questionstage3", fetch = FetchType.EAGER)
    @JsonBackReference
    private Set<AnswerStage3> answer;

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

	public Set<AnswerStage3> getAnswer() {
		return answer;
	}

	public void setAnswer(Set<AnswerStage3> answer) {
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

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return "QuestionStage3 [id=" + id + ", value=" + value + ", type=" + type + ", choiceSet=" + choiceSet
				+ ", rank=" + rank + ", answer=" + answer + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
				+ ", deletedAt=" + deletedAt + "]";
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
	
	public AnswerStage3 getAnswerStage3ByCompanyId(Long id) {
		for(AnswerStage3 ans : this.answer) {
			Company company = ans.getCompany();
			if(company != null && company.getId() == id)
				return ans;
		}
		
		return null;
	}
}
