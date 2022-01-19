package com.crm.app.repository;

import com.crm.app.entity.Groupe;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    List<Groupe> findAllByDeletedAtIsNull();
    List<Groupe> findAllByCreatedAtBetweenAndNomLike(Date debut, Date fin, String nom);

}
