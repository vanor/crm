package com.crm.app.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;

import com.crm.app.dto.ProgressDto;
import com.crm.app.entity.AnswerStage1;
import com.crm.app.entity.AnswerStage2;
import com.crm.app.entity.AnswerStage3;
import com.crm.app.entity.AnswerStage4;
import com.crm.app.entity.Company;
import com.crm.app.entity.QuestionStage1;
import com.crm.app.entity.QuestionStage2;
import com.crm.app.entity.QuestionStage3;
import com.crm.app.entity.QuestionStage4;
import com.crm.app.entity.Secteur;

public interface CompanyService {
	Company findById(Long id);
	Company findByName(String name);
	Company save(Company company);
	List<Company> findAll();
	
	QuestionStage1 findQuestionStage1ById(Long id);
	QuestionStage2 findQuestionStage2ById(Long id);
	QuestionStage3 findQuestionStage3ById(Long id);
	QuestionStage4 findQuestionStage4ById(Long id);
	
	Secteur findSecteurById(Long id);
	List<Secteur> findAllSectors();
	List<Secteur> findSectorsByCompany(Company company);
	
	List<QuestionStage1> findAllQuestionsStage1();
	List<QuestionStage2> findAllQuestionsStage2();
	List<QuestionStage3> findAllQuestionsStage3();
	List<QuestionStage4> findAllQuestionsStage4();
	
	List<QuestionStage1> findUserQuestionsStage1();
	List<QuestionStage2> findUserQuestionsStage2();
	List<QuestionStage3> findUserQuestionsStage3();
	List<QuestionStage4> findUserQuestionsStage4();
	
	List<QuestionStage1> findCompanyQuestionsStage1();
	
	List<QuestionStage2> findAllQuestionsStage2ByCompany(Company company);
	List<QuestionStage2> findUserQuestionsStage2ByCompany(Company company);
	
	List<AnswerStage1> findAllAnswersStage1ByCompany(Company company);
	List<AnswerStage2> findAllAnswersStage2ByCompany(Company company);
	List<AnswerStage3> findAllAnswersStage3ByCompany(Company company);
	List<AnswerStage4> findAllAnswersStage4ByCompany(Company company);
	
	void saveAllAnswersAndFiles(Company company, Map<String, String> datas, List<Part> files) throws RuntimeException;
	void saveCompanyFiles(Company company, List<Part> files) throws RuntimeException;
	boolean isStage1CompletedByCompany(Company company);
	
	ProgressDto getProgress(Company company);
	
	AnswerStage1 saveAnswerStage1(AnswerStage1 answerStage1);
	AnswerStage2 saveAnswerStage2(AnswerStage2 answerStage2);
}
