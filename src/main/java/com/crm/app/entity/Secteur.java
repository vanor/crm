package com.crm.app.entity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "sector")
public class Secteur {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="native")
	@GenericGenerator(name = "native", strategy = "native")
    private Long id;

	@Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
 
	@OneToMany(mappedBy = "secteur", fetch = FetchType.EAGER)
	@JsonBackReference
	private Set<QuestionStage2> questionstage2;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<QuestionStage2> getQuestionstage2() {
		return questionstage2;
	}

	public void setQuestionstage2(Set<QuestionStage2> questionstage2) {
		this.questionstage2 = questionstage2;
	}

	@Override
	public String toString() {
		return "Secteur [id=" + id + ", name=" + name + ", questionstage2=" + questionstage2 + "]";
	}
	
	public List<QuestionStage2> getSortedQuestions() {
		return this.questionstage2
				.stream()
				.sorted((q1, q2) -> q1.getRank().compareTo(q2.getRank()))
				.collect(Collectors.toList());
	}
	
	public List<QuestionStage2> getSortedUserQuestions() {
		return this.questionstage2
				.stream()
				.filter(q -> q.getValidatorSideNumber() == null || q.getValidatorSideNumber() == 1)
				.sorted((q1, q2) -> q1.getRank().compareTo(q2.getRank()))
				.collect(Collectors.toList());
	}
	
	public List<QuestionStage2> getSortedCompanyQuestions() {
		return this.questionstage2
				.stream()
				.filter(q -> q.getValidatorSideNumber() == null || q.getValidatorSideNumber() == 2)
				.sorted((q1, q2) -> q1.getRank().compareTo(q2.getRank()))
				.collect(Collectors.toList());
	}
}
