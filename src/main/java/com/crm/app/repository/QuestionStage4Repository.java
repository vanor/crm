package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.QuestionStage4;

public interface QuestionStage4Repository extends JpaRepository<QuestionStage4,Long>{
	List<QuestionStage4> findAllByOrderByRankAsc();
	List<QuestionStage4> findAllByValidatorSideNumberIsNullOrValidatorSideNumberNotOrderByRankAsc(Integer notInt);
}
