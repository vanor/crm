package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.AnswerStage3;
import com.crm.app.entity.Company;

public interface AnswerStage3Repository extends JpaRepository<AnswerStage3,Long>{
	List<AnswerStage3> findAllByCompany(Company company);
	List<AnswerStage3> findAllByCompanyAndQuestionstage3_ValidatorSideNumberNotNull(Company company);
}
