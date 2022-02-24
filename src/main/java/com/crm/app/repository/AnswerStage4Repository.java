package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.AnswerStage4;
import com.crm.app.entity.Company;

public interface AnswerStage4Repository extends JpaRepository<AnswerStage4,Long>{
	List<AnswerStage4> findAllByCompany(Company company);
	List<AnswerStage4> findAllByCompanyAndQuestionstage4_ValidatorSideNumberNotNull(Company company);
}
