package com.crm.app.service;

import java.util.List;

import com.crm.app.entity.Company;
import com.crm.app.entity.QuestionStage1;
import com.crm.app.entity.QuestionStage2;
import com.crm.app.entity.QuestionStage3;
import com.crm.app.entity.QuestionStage4;

public interface CompanyService {
	Company findById(Long id);
	Company findByName(String name);
	Company save(Company company);
	List<Company> findAll();
	
	List<QuestionStage1> findAllQuestionsStage1();
	List<QuestionStage2> findAllQuestionsStage2();
	List<QuestionStage3> findAllQuestionsStage3();
	List<QuestionStage4> findAllQuestionsStage4();
}
