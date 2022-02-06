package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.QuestionStage3;

public interface QuestionStage3Repository extends JpaRepository<QuestionStage3,Long> {
	List<QuestionStage3> findAllByOrderByRankAsc();
}
