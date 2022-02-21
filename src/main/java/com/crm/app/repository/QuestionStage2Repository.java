package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.crm.app.entity.QuestionStage2;

public interface QuestionStage2Repository extends JpaRepository<QuestionStage2,Long>{
	List<QuestionStage2> findAllByOrderByRankAsc();
	List<QuestionStage2> findAllBySecteur_IdInOrderByRankAsc(List<Long> ids);
	List<QuestionStage2> findAllByValidatorSideNumberNotOrderByRankAsc(Integer notInt);
	
	@Query("SELECT q FROM QuestionStage2 q WHERE (q.validatorSideNumber IS NULL OR q.validatorSideNumber <> ?1) AND q.secteur.id IN ?2 ORDER BY q.rank ASC")
	List<QuestionStage2> findAllByValidatorSideNumberIsNotAndSecteurIdIn(Integer notInt, List<Long> ids);
}
