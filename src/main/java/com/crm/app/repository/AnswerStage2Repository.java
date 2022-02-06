package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.AnswerStage2;
import com.crm.app.entity.Company;

public interface AnswerStage2Repository extends JpaRepository<AnswerStage2,Long>{
	List<AnswerStage2> findAllByCompany(Company company);
}
