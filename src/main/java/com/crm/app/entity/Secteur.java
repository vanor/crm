package com.crm.app.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "answerstage2")
public class Secteur  implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
 @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
 
 @OneToMany(mappedBy = "secteur", fetch = FetchType.EAGER)
 @JsonManagedReference
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
 
 

}
