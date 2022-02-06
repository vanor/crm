package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.QuestionStage2;

public interface QuestionStage2Repository extends JpaRepository<QuestionStage2,Long>{
	List<QuestionStage2> findAllByOrderByRankAsc();
}
