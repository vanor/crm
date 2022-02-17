package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.QuestionStage2;

public interface QuestionStage2Repository extends JpaRepository<QuestionStage2,Long>{
	List<QuestionStage2> findAllByOrderByRankAsc();
	List<QuestionStage2> findAllBySecteur_IdInOrderByRankAsc(List<Long> ids);
	List<QuestionStage2> findAllByValidatorSideNumberNotAndSecteur_IdInOrderByRankAsc(Integer notInt, List<Long> ids);
	List<QuestionStage2> findAllByValidatorSideNumberNotOrderByRankAsc(Integer notInt);
}
