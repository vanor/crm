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
@Table(name = "company")
public class Company implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
 
 @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;
 
 @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
 @JsonManagedReference
 private Set<AnswerStage1> answerstage1;
 
 @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
 @JsonManagedReference
 private Set<AnswerStage2> answerstage2;
 
 @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
 @JsonManagedReference
 private Set<AnswerStage3> answerstage3;
 
 @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
 @JsonManagedReference
 private Set<AnswerStage4> answerstage4;

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

public Set<AnswerStage1> getAnswerstage1() {
	return answerstage1;
}

public void setAnswerstage1(Set<AnswerStage1> answerstage1) {
	this.answerstage1 = answerstage1;
}

public Set<AnswerStage2> getAnswerstage2() {
	return answerstage2;
}

public void setAnswerstage2(Set<AnswerStage2> answerstage2) {
	this.answerstage2 = answerstage2;
}

public Set<AnswerStage3> getAnswerstage3() {
	return answerstage3;
}

public void setAnswerstage3(Set<AnswerStage3> answerstage3) {
	this.answerstage3 = answerstage3;
}

public Set<AnswerStage4> getAnswerstage4() {
	return answerstage4;
}

public void setAnswerstage4(Set<AnswerStage4> answerstage4) {
	this.answerstage4 = answerstage4;
}

@Override
public String toString() {
	return "Company [id=" + id + ", name=" + name + ", answerstage1=" + answerstage1 + ", answerstage2=" + answerstage2
			+ ", answerstage3=" + answerstage3 + ", answerstage4=" + answerstage4 + "]";
}





 

}
