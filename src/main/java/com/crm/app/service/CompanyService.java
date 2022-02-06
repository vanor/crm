package com.crm.app.service;

import java.util.List;
import java.util.Map;

import com.crm.app.entity.AnswerStage1;
import com.crm.app.entity.AnswerStage2;
import com.crm.app.entity.AnswerStage3;
import com.crm.app.entity.AnswerStage4;
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
	
	QuestionStage1 findQuestionStage1ById(Long id);
	QuestionStage2 findQuestionStage2ById(Long id);
	QuestionStage3 findQuestionStage3ById(Long id);
	QuestionStage4 findQuestionStage4ById(Long id);
	
	List<QuestionStage1> findAllQuestionsStage1();
	List<QuestionStage2> findAllQuestionsStage2();
	List<QuestionStage3> findAllQuestionsStage3();
	List<QuestionStage4> findAllQuestionsStage4();
	
	List<AnswerStage1> findAllAnswersStage1ByCompany(Company company);
	List<AnswerStage2> findAllAnswersStage2ByCompany(Company company);
	List<AnswerStage3> findAllAnswersStage3ByCompany(Company company);
	List<AnswerStage4> findAllAnswersStage4ByCompany(Company company);
	
	List<AnswerStage1> saveAllAnswersStage1(Company company, Map<String, String> datas) throws RuntimeException;
}
