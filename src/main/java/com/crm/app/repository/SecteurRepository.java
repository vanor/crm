package com.crm.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crm.app.entity.Secteur;

public interface SecteurRepository extends JpaRepository<Secteur, Long>{
	List<Secteur> findAllByIdInOrderByIdAsc(List<Long> ids);
}
