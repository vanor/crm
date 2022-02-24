package com.crm.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.crm.app.entity.Reporting;
import com.crm.app.entity.Utilisateur;


public interface ReportingRepository extends JpaRepository<Reporting,Long>{
	
	List<Reporting> findAllByUser(Utilisateur User);
	
	@Query(value = "SELECT * FROM reporting b WHERE b.created_by = :id and b.createdat<= :datef and b.createdat>= :dated", 
			  nativeQuery = true)
	public List<Reporting> findAllBydate(@Param("id") String id,@Param("datef") String datef, @Param("dated") String dated);

}
