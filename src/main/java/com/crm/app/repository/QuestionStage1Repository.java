package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.QuestionStage1;

public interface QuestionStage1Repository extends JpaRepository<QuestionStage1, Long> {
	List<QuestionStage1> findAllByOrderByRankAsc();
	List<QuestionStage1> findAllByPrioritySectorNumberNotNull();
}
