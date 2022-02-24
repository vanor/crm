package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.AnswerStage1;
import com.crm.app.entity.Company;

public interface AnswerStage1Repository extends JpaRepository<AnswerStage1,Long>{
	List<AnswerStage1> findAllByCompany(Company company);
	List<AnswerStage1> findAllByCompanyAndQuestionstage1_ValidatorSideNumberNotNull(Company company);
}
